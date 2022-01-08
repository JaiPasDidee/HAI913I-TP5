package spoon;

import java.util.logging.*;

import ecommerce.Order;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Order.class.getName());

    public static void main (String[] args) throws Exception {
        //Question 3
        Launcher spoon = new Launcher();
        LogProcessor logProcessor = new LogProcessor();
        spoon.addInputResource("./src/");

        spoon.addProcessor(logProcessor);

        spoon.run();

    }
}
