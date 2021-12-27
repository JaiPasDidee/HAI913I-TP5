package spoon;
public class LogProcessor extends spoon.processing.AbstractProcessor<spoon.reflect.declaration.CtExecutable> {
    @java.lang.Override
    public boolean isToBeProcessed(spoon.reflect.declaration.CtExecutable element) {
        java.lang.String methodName = element.getSimpleName();
        spoon.reflect.declaration.CtClass classe = element.getParent(spoon.reflect.declaration.CtClass.class);
        if ((classe == null) || (!classe.getQualifiedName().equals("utils.User")))
            return false;

        return (!methodName.startsWith("get")) && (!methodName.startsWith("set"));
    }

    @java.lang.Override
    public void process(spoon.reflect.declaration.CtExecutable element) {
        if (element.getBody() == null)
            return;

        java.lang.String methodName = element.getSimpleName();
        spoon.reflect.code.CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
        // Snippet which contains the log.
        final java.lang.String value = "LOG";
        snippet.setValue(value);
        java.lang.System.out.println(methodName);
        // Inserts the snippet at the beginning of the method body.
        switch (methodName) {
            case "fetch" :
                break;
        }
    }
}