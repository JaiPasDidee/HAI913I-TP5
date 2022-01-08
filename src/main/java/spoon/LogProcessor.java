package spoon;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtExecutable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogProcessor extends AbstractProcessor<CtExecutable<?>> {

   @Override
    public boolean isToBeProcessed(CtExecutable element) {
       CtClass<?> classe = element.getParent(CtClass.class);

       return classe != null && classe.getQualifiedName().equals("ecommerce.Order");
   }

    @Override
    public void process(CtExecutable element) {
        if(element.getBody() == null)
            return;

        String methodName = element.getSimpleName();
        CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();

        // Snippet which contains the log.
        final String event;

        // Inserts the snippet at the beginning of the method body.
        switch(methodName) {
            case "display":
            case "fetch":
                event = "Read"; break;
            case "add":
            case "delete":
                event = "Write"; break;
            default:
                event = null;
        }

        if(event != null)
            snippet.setValue(log(event, "TODO", methodName)); // TODO
    }

    private String log(String event, String username, String action) {
       String template = "Order.get%sLogger().log(Level.FINER, \"[%s - %s] L'utilisateur %s a réalisé l'opération %s\")";
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();

       return String.format(template, event, dtf.format(now), event.toUpperCase(Locale.ROOT), username, action);
    }
}
