package spoon;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtExecutable;

public class LogProcessor extends AbstractProcessor<CtExecutable> {

   @Override
    public boolean isToBeProcessed(CtExecutable element) {
       String methodName = element.getSimpleName();
       CtClass classe = element.getParent(CtClass.class);

       return classe != null && classe.getQualifiedName().equals("ecommerce.Command");
   }

    @Override
    public void process(CtExecutable element) {
        if(element.getBody() == null)
            return;

        String methodName = element.getSimpleName();
        CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();

        // Snippet which contains the log.
        final String value;

        // Inserts the snippet at the beginning of the method body.
        switch(methodName) {
            case "fetch":
                value = "LOGGER.log(Level.FINER, \"test\");"; break;
            default:
                value = null;
        }

        if(value != null)
            snippet.setValue(value);
    }
}
