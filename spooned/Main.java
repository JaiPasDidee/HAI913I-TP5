import spoon.Launcher;
import spoon.LogProcessor;
import java.util.*;
import java.util.logging.*;
public class Main {
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Command.class.getName());

    public static void main(java.lang.String[] args) throws java.lang.Exception {
        System.out.println("Enter in the method main from class Main");;
        // Question 1
        java.util.Map<java.lang.Integer, Product> products = new java.util.HashMap<java.lang.Integer, Product>();
        products.put(1, new Product(1, "p1", 20, new java.util.GregorianCalendar(2021, 11, 30)));
        products.put(2, new Product(2, "p2", 25, new java.util.GregorianCalendar(2021, 11, 29)));
        Command command = new Command(products);
        command.display();
        command.fetch(3);
        Product add = new Product(1, "p3", 30, new java.util.GregorianCalendar(2021, 12, 02));
        command.add(add);
        command.delete(3);
        command.update(1, "d1", -1, null);
        command.display();
        // Question 2
        Main.LOGGER.setLevel(java.util.logging.Level.INFO);
        /* retrieving the global log manager object
        note: created during class initialization and cannot be changed subsequently
         */
        java.util.logging.LogManager globalLogManager = java.util.logging.LogManager.getLogManager();
        // set the logging level of all loggers to Level.FINE
        java.util.logging.LogManager.getLogManager().getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME).setLevel(java.util.logging.Level.FINE);
        HTMLFormateur htmlFormateur = new HTMLFormateur();
        java.util.logging.Handler fileHandler = null;
        try {
            fileHandler = new java.util.logging.FileHandler("./commands.log");
            Main.LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(htmlFormateur);
            fileHandler.setLevel(java.util.logging.Level.ALL);
            Main.LOGGER.setLevel(java.util.logging.Level.ALL);
            Main.LOGGER.finest("Finnest message: Logger with SIMPLE FORMATTER");
        } catch (java.lang.Exception e) {
            Main.LOGGER.log(java.util.logging.Level.SEVERE, "Error occur in FileHandler.", e);
        }
        // Qestion 3
        Launcher spoon = new Launcher();
        LogProcessor logProcessor = new LogProcessor();
        spoon.addInputResource("./src/");
        spoon.addProcessor(logProcessor);
        spoon.run();
    }
}