package spoon;
public class LogProcessor extends spoon.processing.AbstractProcessor<spoon.reflect.declaration.CtExecutable> {
    /**
     *
     *
     * @unknown public boolean isToBeProcessed(CtExecutable candidate) {
    System.out.println(candidate.getParent().toString());
    if(candidate.getSignature().toString() == "utils.Command")
    return true;
    return false;
    }*
     */
    @java.lang.Override
    public void process(spoon.reflect.declaration.CtExecutable element) {
        LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", e);;
        spoon.reflect.code.CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
        // Snippet which contains the log.
        final java.lang.String value = java.lang.String.format("LOGGER.log(Level.SEVERE, \"Error occur in FileHandler.\", e);", element.getSimpleName(), element.getParent(spoon.reflect.declaration.CtClass.class).getSimpleName());
        snippet.setValue(value);
        // Inserts the snippet at the beginning of the method body.
        if (element.getBody() != null) {
            element.getBody().insertBegin(snippet);
        }
    }
}