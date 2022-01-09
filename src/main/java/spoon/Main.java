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

        spoon.addInputResource("./src/");
        spoon.getEnvironment().setAutoImports(true);
        spoon.addProcessor(mainProcessor);
        spoon.addProcessor(initProcessor);
        spoon.addProcessor(logProcessor);
        spoon.run();
    }
}
