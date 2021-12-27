package spoon;
public class LogProcessorTest extends spoon.processing.AbstractProcessor<spoon.reflect.declaration.CtExecutable> {
    @java.lang.Override
    public void process(spoon.reflect.declaration.CtExecutable element) {
        spoon.reflect.code.CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
        // Snippet which contains the log.
        final java.lang.String value = java.lang.String.format("LOGGER.log(Level.FINE, \"Error occur in FileHandler.\", e);", element.getSimpleName(), element.getParent(spoon.reflect.declaration.CtClass.class).getSimpleName());
        snippet.setValue(value);
        // Inserts the snippet at the beginning of the method body.
        if (element.getBody() != null) {
            element.getBody().insertBegin(snippet);
        }
    }
}