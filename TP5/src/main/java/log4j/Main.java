package log4j;

import ecommerce.Formatter;
import ecommerce.Product;
import ecommerce.Repository;
import ecommerce.User;

import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger("Question 2");

    public static void main (String[] args) {
        //Question 1

        // Création de la liste des produits
        Repository.init();
        // Réalisation des scénarios utilisateur
        makeScenarios();

        //Question 2

        LOGGER.setLevel(Level.INFO);
        Formatter formatter = new Formatter();
        Handler fileHandler;

        try{
            fileHandler = new FileHandler("./commands.log");
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);

            fileHandler.setLevel(Level.INFO);
            LOGGER.info("Test of an info log");
            LOGGER.log(Level.SEVERE, "Test of a severe log");
        }catch (Exception e){
            System.err.println("Une erreur est survenue...");
            e.printStackTrace();
        }
    }

    private static void makeScenarios() {
        // Création de l'utilisateur
        User user = new User("Georges", "georges97@gmail.com", "azerty", 75);

        // Scénario pour user
        Repository.display(user);
        Repository.update(user, 1, null, 690, null);
        Repository.fetch(user, 1);
        Repository.add(user, new Product("P4", 2));
        Repository.delete(user, 4);
        Repository.display(user);
        Repository.add(user, new Product("P5", 10));
        Repository.update(user, 5, "P5u", -1, null);
        Repository.fetch(user, 5);
        Repository.delete(user, 5);
    }
}
