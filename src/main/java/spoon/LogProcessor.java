package spoon;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtExecutable;

public class LogProcessor extends AbstractProcessor<CtExecutable> {

   /** @Override
    public boolean isToBeProcessed(CtExecutable candidate) {
        System.out.println(candidate.getParent().toString());
        if(candidate.getSignature().toString() == "Command")
            return true;
        return false;
    }**/

    @Override
    public void process(CtExecutable element) {
        CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();

        // Snippet which contains the log.
        final String value = String.format("LOGGER.log(Level.SEVERE, \"Error occur in FileHandler.\", e);",
                element.getSimpleName(),
                element.getParent(CtClass.class).getSimpleName());
        snippet.setValue(value);

        // Inserts the snippet at the beginning of the method body.
        if (element.getBody() != null) {
            element.getBody().insertBegin(snippet);
        }
    }
}
