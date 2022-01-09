package log4j;

import ecommerce.Formatter;
import ecommerce.Repository;
import ecommerce.User;

import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Repository.class.getName());

    public static void main (String[] args) {
        //Question 1

        // Création de la liste des produits
        Repository.init();
        // Réalisation des scénarios utilisateur
        makeScenarios();

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
        ecommerce.Formatter formatter = new Formatter();
        Handler fileHandler;

        try{
            fileHandler = new FileHandler("./commands.log");
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);

            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.finest("Finnest message: Logger with SIMPLE FORMATTER");

        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }
    }

    private static void makeScenarios() {
        // Création de l'utilisateur
        User user = new User("Georges", "georges97@gmail.com", "azerty", 75);

        // Scénario pour user
        // TODO Faire la même que user5
    }
}
