package ecommerce;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Création de la liste des produits
        Repository.init();
        // Création des loggers
        createLoggers();
        // Réalisation des scénarios utilisateur
        makeScenarios();
    }

    private static void makeScenarios() {
        // Création des utilisateurs
        User user1 = new User("Georges", "georges97@gmail.com", "azerty", 75);
        User user2 = new User("Sandrine", "sand-rine@yahoo.fr", "54NDY", 23);
        User user3 = new User("Patrick", "pat.dupont@gmail.com", "P47R1CK!", 46);
        User user4 = new User("Lucas", "XxLucasxX@gmail.com", "e4M#%q?G!", 17);
        User user5 = new User("Camille", "camz21@orange.fr", "camz21-P455", 32);

        // Scénario pour user1 (autant de lectures/écritures)
        Repository.display(user1);
        Repository.fetch(user1, 1);
        Repository.fetch(user1, 3);
        Repository.add(user1, new Product("P4", 400, LocalDate.now()));
        Repository.display(user1);
        Repository.fetch(user1, 4);
        Repository.add(user1, new Product("P5", 60, LocalDate.now()));
        Repository.add(user1, new Product("P6", 3, LocalDate.now()));
        Repository.add(user1, new Product("P7", 900, LocalDate.now()));
        Repository.add(user1, new Product("P8", 777, LocalDate.now()));
        Repository.delete(user1, 6);
        Repository.display(user1);

        // Scénario pour user2 (écriture uniquement)
        Repository.add(user2, new Product("P9", 2499, LocalDate.now()));
        Repository.add(user2, new Product("P10", 1, LocalDate.now()));
        Repository.update(user2, 10, null, 2, null);
        Repository.add(user2, new Product("P11", 14, LocalDate.now()));
        Repository.add(user2, new Product("P12", 570, LocalDate.now()));
        Repository.delete(user2, 11);
        Repository.add(user2, new Product("P13", 68, LocalDate.now()));
        Repository.update(user2, 7, "P7u", -1, null);
        Repository.update(user2, 13, "P13u", 69, null);
        Repository.delete(user2, 5);

        // Scénario pour user3 (lecture uniquement)
        Repository.display(user3);
        Repository.fetch(user3, 10);
        Repository.display(user3);
        Repository.fetch(user3, 4);
        Repository.display(user3);
        Repository.fetch(user3, 13);
        Repository.display(user3);
        Repository.fetch(user3, 10);
        Repository.display(user3);
        Repository.fetch(user3, 4);
        Repository.display(user3);
        Repository.fetch(user3, 13);

        // Scénario pour user4 (lecture des produits les plus chers)
        Repository.display(user4);
        Repository.fetch(user4, 4);
        Repository.fetch(user4, 7);
        Repository.display(user4);
        Repository.fetch(user4, 8);
        Repository.fetch(user4, 9);
        Repository.display(user4);
        Repository.fetch(user4, 12);
        Repository.fetch(user4, 7);
        Repository.display(user4);
        Repository.fetch(user4, 9);
        Repository.fetch(user4, 8);

        // Scénario pour user5 (un peu de tout)
        // TODO
        Repository.fetch(user5, 9);
    }

    private static void createLoggers() { }
}
