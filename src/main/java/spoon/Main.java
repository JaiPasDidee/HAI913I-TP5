package spoon;

import ecommerce.Order;
import ecommerce.Product;
import ecommerce.User;

import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {


    //Questions 3, 4 and 5
    public static void main (String[] args) {
        Launcher spoon = new Launcher();
        LogProcessor logProcessor = new LogProcessor();
        spoon.addInputResource("./src/");
        spoon.addProcessor(logProcessor);
        spoon.run();

        Map<Integer, Product> products = new HashMap<>();
        products.put(1,new Product(1, "p1", 20, new GregorianCalendar(2021, Calendar.NOVEMBER, 30)));
        products.put(2,new Product(2, "p2", 25, new GregorianCalendar(2021, Calendar.NOVEMBER, 29)));
        Order order = new Order(products);

        User user1 = createUser(1, order);
        User user2 = createUser(2, order);
        Formatter formatter = new Formatter();
        Handler fileHandlerRead;
        Handler fileHandlerWrite;
        Handler fileHandlerExpensive;
        Logger LOGGER_READ = order.getLOGGER();
        Logger LOGGER_WRITE = order.getLOGGER();
        Logger LOGGER_EXPENSIVE = order.getLOGGER();

        try{
            fileHandlerRead = new FileHandler("./logRead.log");
            LOGGER_READ.addHandler(fileHandlerRead);
            fileHandlerRead.setFormatter(formatter);
            fileHandlerRead.setLevel(Level.ALL);
            LOGGER_READ.setLevel(Level.ALL);

            fileHandlerWrite = new FileHandler("./logWrite.log");
            LOGGER_WRITE.addHandler(fileHandlerWrite);
            fileHandlerWrite.setFormatter(formatter);
            fileHandlerWrite.setLevel(Level.ALL);
            LOGGER_WRITE.setLevel(Level.ALL);

            fileHandlerExpensive = new FileHandler("./logExpensive.log");
            LOGGER_EXPENSIVE.addHandler(fileHandlerExpensive);
            fileHandlerExpensive.setFormatter(formatter);
            fileHandlerExpensive.setLevel(Level.ALL);
            LOGGER_EXPENSIVE.setLevel(Level.ALL);

            formatter.setUser(user1);
            user1.display();

            formatter.setUser(user2);
            user2.update(1, "aa", -1, null);

        }catch (Exception e){
            LOGGER_READ.log(Level.SEVERE, "Error occur in FileHandler.", e);
            LOGGER_WRITE.log(Level.SEVERE, "Error occur in FileHandler.", e);
            LOGGER_EXPENSIVE.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }
    }

    public static User createUser(int id, Order order){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedName = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String generatedEmal = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        generatedEmal += "@gmail.com";

        String generatedPassword = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        int generatedAge = ThreadLocalRandom.current().nextInt(18, 99 + 1);
        return new User(id,generatedName, generatedEmal, generatedPassword, generatedAge, order);
    }
}
