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
        InitProcessor initProcessor = new InitProcessor();
        LogProcessor logProcessor = new LogProcessor();
        spoon.addInputResource("./src/");
        spoon.addProcessor(initProcessor);
        spoon.run();

        Map<Integer, Product> products = new HashMap<>();
        products.put(1,new Product(1, "p1", 20, new GregorianCalendar(2021, Calendar.NOVEMBER, 30)));
        products.put(2,new Product(2, "p2", 25, new GregorianCalendar(2021, Calendar.NOVEMBER, 29)));
        Order order = new Order(products);

        User user1 = createUser(1, order);
        User user2 = createUser(2, order);
        User user3 = createUser(3, order);
        User user4 = createUser(4, order);
        User user5 = createUser(5, order);

        //TODO modifier le main pour ger les bons logger
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

            formatter.setUser(user4);
            user4.fetch(1);
            user4.add(new Product(1, "p3", 30, new GregorianCalendar(2021, Calendar.DECEMBER, 2)));

            formatter.setUser(user1);
            user1.display();

            formatter.setUser(user3);
            user3.delete(1);

            formatter.setUser(user5);
            user5.update(2, null, 50, null);
            user5.display();

            formatter.setUser(user2);
            user2.display();
            user2.add(new Product(1, "p1 bis", 100, new GregorianCalendar(2022, Calendar.JANUARY, 2)));
            user2.fetch(2);

            formatter.setUser(user1);
            user1.display();
            user1.add(new Product(4, "p4", 200, new GregorianCalendar(2023, Calendar.DECEMBER, 23)));
            user1.fetch(4);

            formatter.setUser(user4);
            user4.display();
            user4.fetch(4);

            formatter.setUser(user3);
            user3.fetch(4);

            formatter.setUser(user5);
            user5.fetch(4);

            formatter.setUser(user2);
            user2.fetch(4);
            user2.display();

            formatter.setUser(user1);
            user1.delete(4);
            user1.display();

            //TODO faire d'autres scenarios ?

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
