package spoon.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtExecutable;

public class MainProcessor extends AbstractProcessor<CtExecutable<?>> {

    @Override
    public boolean isToBeProcessed(CtExecutable element) {
        CtClass<?> classe = element.getParent(CtClass.class);

        return classe != null && classe.getQualifiedName().equals("ecommerce.Main");
    }

    @Override
    public void process(CtExecutable element) {
        if(element.getBody() == null || !element.getSimpleName().equals("createLoggers"))
            return;

        CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
        snippet.setValue("try{\n" +
                "            Formatter formatter = new Formatter();\n" +
                "            Handler readFH = new FileHandler(\"./reads.log\");\n" +
                "            Handler writeFH = new FileHandler(\"./writes.log\");\n" +
                "            Logger readLogger = Repository.getReadLogger();\n" +
                "            Logger writeLogger = Repository.getWriteLogger();\n" +
                "\n" +
                "            readFH.setFormatter(formatter);\n" +
                "            readFH.setLevel(Level.ALL);\n" +
                "            readLogger.setLevel(Level.ALL);\n" +
                "            readLogger.addHandler(readFH);\n" +
                "\n" +
                "            writeFH.setFormatter(formatter);\n" +
                "            writeFH.setLevel(Level.ALL);\n" +
                "            writeLogger.setLevel(Level.ALL);\n" +
                "            writeLogger.addHandler(writeFH);\n" +
                "        }catch (Exception e){\n" +
                "            System.err.println(\"Impossible d'initialiser les loggers...\");\n" +
                "            e.printStackTrace();\n" +
                "            System.exit(1);\n" +
                "        }");

        element.getBody().insertBegin(snippet);
    }
}
