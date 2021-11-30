import java.io.IOException;
import java.util.*;
import java.util.logging.*;

import spoon.Launcher;
import spoon.LogProcessor;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.factory.Factory;

import java.lang.annotation.Annotation;
import java.util.List;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Command.class.getName());

    public static void main (String[] args)throws Exception{
        //Question 1
        Map<Integer, Product> products = new HashMap<Integer, Product>();
        products.put(1,new Product(1, "p1", 20, new GregorianCalendar(2021, 11, 30)));
        products.put(2,new Product(2, "p2", 25, new GregorianCalendar(2021, 11, 29)));
        Command command = new Command(products);

        command.display();

        command.fetch(3);

        Product add = new Product(1, "p3", 30, new GregorianCalendar(2021, 12, 02));
        command.add(add);

        command.delete(3);

        command.update(1, "d1", -1, null);

        command.display();

        //Question 2
        LOGGER.setLevel(Level.INFO);
        /*
         * retrieving the global log manager object
         * note: created during class initialization and cannot be changed subsequently
         */
        LogManager globalLogManager = LogManager.getLogManager();
        // set the logging level of all loggers to Level.FINE
        LogManager.getLogManager()
                .getLogger(Logger.GLOBAL_LOGGER_NAME)
                .setLevel(Level.FINE);
        HTMLFormateur htmlFormateur = new HTMLFormateur();
        Handler fileHandler = null;

        try{
            fileHandler = new FileHandler("./commands.log");
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(htmlFormateur);

            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.finest("Finnest message: Logger with SIMPLE FORMATTER");
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }

        //Qestion 3
        Launcher spoon = new Launcher();
        LogProcessor logProcessor = new LogProcessor();
        spoon.addInputResource("./src/");

        spoon.addProcessor(logProcessor);

        spoon.run();

    }
}
