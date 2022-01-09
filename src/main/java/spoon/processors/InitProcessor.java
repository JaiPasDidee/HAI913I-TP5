package spoon.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;

import java.util.EnumSet;
import java.util.Locale;
import java.util.logging.Logger;

public class InitProcessor extends AbstractProcessor<CtClass<?>> {

    @Override
    public boolean isToBeProcessed(CtClass element) {
        return element.getQualifiedName().equals("ecommerce.Repository");
    }

    @Override
    public void process(CtClass element) {
        // Create the loggers in the class
        createLogger(element, "Read");
        createLogger(element, "Write");
    }

    private void createLogger(CtClass<?> element, String name) {
        CtCodeSnippetExpression<Object> snippet = element.getFactory().Core().createCodeSnippetExpression();
        CtTypeReference<Object> fieldType = element.getFactory().createTypeParameterReference(Logger.class.getCanonicalName());
        EnumSet<ModifierKind> modifiers = EnumSet.of(ModifierKind.STATIC, ModifierKind.PRIVATE, ModifierKind.FINAL);

        snippet.setValue("Logger.getLogger(\"" + name.toLowerCase(Locale.ROOT) + element.getSimpleName() + "\")");
        CtField<?> field = element.getFactory().createField(element, modifiers, fieldType, name.toUpperCase(Locale.ROOT) + "_LOGGER", snippet);

        element.addField(field);
        // Create getter for the logger
        createGetter(element, name);
    }

    private void createGetter(CtClass<?> element, String name) {
        CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
        CtTypeReference<Object> returnType = element.getFactory().createTypeParameterReference(Logger.class.getCanonicalName());
        EnumSet<ModifierKind> modifiers = EnumSet.of(ModifierKind.STATIC, ModifierKind.PUBLIC);
        CtBlock<?> body = element.getFactory().createBlock();

        snippet.setValue("return " + name.toUpperCase(Locale.ROOT) + "_LOGGER");
        body.insertBegin(snippet);
        CtMethod<?> method = element.getFactory().createMethod(element, modifiers, returnType, "get" + name + "Logger", null, null, body);
        element.addMethod(method);
    }

}
