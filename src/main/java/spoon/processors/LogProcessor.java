package spoon.processors;
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

       return classe != null && classe.getQualifiedName().equals("ecommerce.Repository");
   }

    @Override
    public void process(CtExecutable element) {
        if(element.getBody() == null)
            return;

        String methodName = element.getSimpleName();
        // Snippet which contains the log.
        CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
        final String event;

        // Inserts the snippet at the beginning of the method body.
        switch(methodName) {
            case "display":
            case "fetch":
                event = "Read"; break;
            case "add":
            case "update":
            case "delete":
                event = "Write"; break;
            default:
                event = null;
        }

        if(event == null)
            return;

        snippet.setValue(log(event, methodName));
        element.getBody().insertEnd(snippet);
    }

    private String log(String event, String action) {
       String template = "Repository.get%sLogger().log(Level.FINER, \"[%s - %s] L'utilisateur \" + user + \" a réalisé l'opération %s";
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       template += action.equals("display") ? "\")" : " sur le produit \" + product)";

       return String.format(template, event, dtf.format(now), event.toUpperCase(Locale.ROOT), action);
    }
}
