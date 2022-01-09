package ecommerce;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    private static final Map<User, Integer> mostReads = new HashMap<>();
    private static final Map<User, Integer> mostWrites = new HashMap<>();
    private static final Map<User, Product> mostExpensive = new HashMap<>();

    public static void main(String[] args) {
        // Création de la liste des produits
        Repository.init();
        // Création des loggers
        createLoggers();
        // Réalisation des scénarios utilisateur
        makeScenarios();

        try {
            // Extraction des profils utilisateur
            extractProfiles("./reads.log");
            extractProfiles("./writes.log");
            // Sauvegarde des profils extraits
            saveProfile("./mostReads.json", mostReads);
            saveProfile("./mostWrites.json", mostWrites);
            saveProfile("./mostExpensive.json", null);

            System.out.println("Les profils ont bien été créés.");
        } catch (Exception e) {
            System.err.println("Une erreur est survenue pendant l'extraction des profils...");
        }
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
        Repository.add(user1, new Product("P4", 400));
        Repository.display(user1);
        Repository.fetch(user1, 4);
        Repository.add(user1, new Product("P5", 60));
        Repository.add(user1, new Product("P6", 3));
        Repository.add(user1, new Product("P7", 900));
        Repository.add(user1, new Product("P8", 777));
        Repository.delete(user1, 6);
        Repository.display(user1);

        // Scénario pour user2 (écriture uniquement)
        Repository.add(user2, new Product("P9", 2499));
        Repository.add(user2, new Product("P10", 1));
        Repository.update(user2, 10, null, 2);
        Repository.add(user2, new Product("P11", 14));
        Repository.add(user2, new Product("P12", 570));
        Repository.delete(user2, 11);
        Repository.add(user2, new Product("P13", 68));
        Repository.update(user2, 7, "P7u", -1);
        Repository.update(user2, 13, "P13u", 69);
        Repository.delete(user2, 5);

        // Scénario pour user3 (lecture uniquement)
        Repository.display(user3);
        Repository.fetch(user3, 10);
        Repository.display(user3);
        Repository.fetch(user3, 7);
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
        Repository.display(user5);
        Repository.update(user5, 13, null, 690);
        Repository.fetch(user5, 13);
        Repository.add(user5, new Product("P14", 2));
        Repository.delete(user5, 14);
        Repository.display(user5);
        Repository.add(user5, new Product("P15", 10));
        Repository.update(user5, 15, "P15u", -1);
        Repository.fetch(user5, 15);
        Repository.delete(user5, 15);
    }

    private static void extractProfiles(String file) throws Exception {
        Path path = Paths.get(file);
        List<String> logs = Files.readAllLines(path);
        Pattern pattern1 = Pattern.compile("(\\{.*}) a réalisé l'opération (.*) sur le produit (\\{.*})");
        Pattern pattern2 = Pattern.compile("(\\{.*}) a réalisé l'opération (.*) sur le produit (\\d*)");
        Pattern pattern3 = Pattern.compile("(\\{.*}) a réalisé l'opération (.*)");
        Matcher matcher1, matcher2, matcher3;
        ObjectMapper mapper = new ObjectMapper();

        for(String log : logs) {
            matcher1 = pattern1.matcher(log);
            matcher2 = pattern2.matcher(log);
            matcher3 = pattern3.matcher(log);

            User user = null;
            Product product = null;

            if(matcher1.find()) {
                user = mapper.readValue(matcher1.group(1), User.class);
                product = mapper.readValue(matcher1.group(3), Product.class);
            } else if(matcher2.find())
                user = mapper.readValue(matcher2.group(1), User.class);
            else if(matcher3.find())
                user = mapper.readValue(matcher3.group(1), User.class);

            if(user == null)
                continue;

            if(file.equals("./reads.log")) {
                incrementOperation(user, mostReads);
                incrementExpensive(user, product);
            } else
                incrementOperation(user, mostWrites);
        }
    }

    private static void saveProfile(String path, Map<User, Integer> profile) throws Exception {
        String result = profile == null ? toJson() : toJson(profile);
        File file = new File(path);
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(path);

        fileWriter.write("[\n" + result + "\n]");
        fileWriter.close();
    }

    private static String toJson(Map<User, Integer> profile) {
        String template = "{ \"user\": %s, \"operations\": %s }";

        return profile.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> String.format(template, entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(",\n"));
    }

    private static String toJson() {
        String template = "{ \"user\": %s, \"mostExpensiveProduct\": %s }";

        return mostExpensive.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> ((Map.Entry<User, Product>) entry).getValue().getPrice()).reversed())
                .map(entry -> String.format(template, entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(",\n"));
    }

    private static void incrementOperation(User user, Map<User, Integer> profile) {
        if(profile.containsKey(user))
            profile.put(user, profile.get(user)+1);
        else
            profile.put(user, 1);
    }

    private static void incrementExpensive(User user, Product product) {
        if(product == null)
            return;

        if(!mostExpensive.containsKey(user) ||
                (mostExpensive.containsKey(user) && mostExpensive.get(user).getPrice() < product.getPrice()))
            mostExpensive.put(user, product);
    }

    private static void createLoggers() { }
}
