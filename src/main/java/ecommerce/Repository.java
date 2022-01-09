package ecommerce;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Repository {
    private static final Map<Integer, Product> products = new HashMap<>();

    //display products in a repository, where every product has an ID, a
    //name, a price, and an expiration date
    public static void display(User user) {
        System.out.println(products);
    }

    //fetch a product by its ID (if no product with the provided ID exists,
    //an exception must be thrown).
    public static void fetch(User user, int id) {
        Product product = null;

        if(products.containsKey(id))
            product = products.get(id);

        if(product == null) {
            System.err.println("Le produit que vous souhaitez récupérer n'existe pas...");
            return;
        }

        System.out.println(product);
    }

    //add a new product (if a product with the same ID already exists, an
    //exception must be thrown)
    public static void add(User user, Product product) {
        products.put(product.getId(), product);
    }

    private static void put(Product product) {
        products.put(product.getId(), product);
    }

    public static void init() {
        put(new Product("P1", 20, LocalDate.of(2021, 11, 30)));
        put(new Product("P2", 5, LocalDate.of(2017, 11, 3)));
        put(new Product("P3", 13, LocalDate.of(2022, 4, 14)));
    }

    //delete a product by its ID (if no product with the provided ID exists,
    //an exception must be thrown).
    public static void delete(User user, int product) {
        if(!products.containsKey(product)) {
            System.err.println("Le produit que vous souhaitez supprimer n'existe pas...");
            return;
        }

        products.remove(product);
    }

    //update a product’s info (if no product with the provided ID exists,
    //an exception must be thrown)
    public static void update(User user, int id, String name, int price, LocalDate expirationDate) {
        if(!products.containsKey(id)) {
            System.err.println("Le produit que vous souhaitez mettre à jour n'existe pas...");
            return;
        }

        Product product = products.get(id);

        if(name != null)
            product.setName(name);

        if(price > -1)
            product.setPrice(price);

        if(expirationDate != null)
            product.setExpirationDate(expirationDate);
    }
}
