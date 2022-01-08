package spoon;

public class Main {

    //Questions 3, 4 and 5
    public static void main (String[] args) {
        Launcher spoon = new Launcher();
        InitProcessor initProcessor = new InitProcessor();
        LogProcessor logProcessor = new LogProcessor();
        spoon.addInputResource("./src/");
        spoon.addProcessor(initProcessor);
        spoon.run();
    }
}
