package spoon;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;

import java.util.EnumSet;
import java.util.Locale;
import java.util.logging.Logger;

public class InitProcessor extends AbstractProcessor<CtClass<?>> {

    @Override
    public boolean isToBeProcessed(CtClass element) {
        return element.getQualifiedName().equals("ecommerce.Order");
    }

    @Override
    public void process(CtClass element) {


        // Create the loggers in the class
        createLogger(element, "READ");
        createLogger(element, "WRITE");
        createLogger(element, "EXPENSIVE");
    }

    private void createLogger(CtClass<?> element, String name) {
        name = name.toUpperCase(Locale.ROOT);
        CtCodeSnippetExpression<Object> snippet = element.getFactory().Core().createCodeSnippetExpression();
        CtTypeReference<Object> fieldType = element.getFactory().createTypeParameterReference(Logger.class.getCanonicalName());
        EnumSet<ModifierKind> modifiers = EnumSet.of(ModifierKind.STATIC, ModifierKind.PUBLIC, ModifierKind.FINAL);

        snippet.setValue("Logger.getLogger(\"" + name + "_" + element.getSimpleName().toUpperCase(Locale.ROOT) + "\")");
        CtField<?> field = element.getFactory().createField(element, modifiers, fieldType, name + "_LOGGER", snippet);

        element.addField(field);
    }

}
