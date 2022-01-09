package spoon;

import spoon.processors.InitProcessor;
import spoon.processors.LogProcessor;
import spoon.processors.MainProcessor;

public class Main {
    //Questions 3, 4 and 5
    public static void main (String[] args) {
        Launcher spoon = new Launcher();
        MainProcessor mainProcessor = new MainProcessor();
        InitProcessor initProcessor = new InitProcessor();
        LogProcessor logProcessor = new LogProcessor();

        spoon.addInputResource("./src/main/java/ecommerce");
        spoon.setSourceOutputDirectory("./spooned/src/main/java");
        spoon.getEnvironment().setSourceClasspath(new String[] { "./target" });
        spoon.getEnvironment().setAutoImports(true);
        spoon.addProcessor(mainProcessor);
        spoon.addProcessor(initProcessor);
        spoon.addProcessor(logProcessor);
        spoon.run();

        System.out.println("La génération de code pour la traçabilité a été effectuée.");
    }
}
