package log4j;

import ecommerce.Order;
import ecommerce.Product;
import ecommerce.User;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Order.class.getName());

    public static void main (String[] args) throws Exception {
        //Question 1
        Map<Integer, Product> products = new HashMap<Integer, Product>();
        products.put(1,new Product(1, "p1", 20, new GregorianCalendar(2021, 11, 30)));
        products.put(2,new Product(2, "p2", 25, new GregorianCalendar(2021, 11, 29)));
        Order order = new Order(products);
        User user = new User(1, "nicolas","nicolas@gmail.com", "a", 23, order);

        user.display();
        user.fetch(3);

        Product add = new Product(1, "p3", 30, new GregorianCalendar(2021, 12, 02));

        user.add(add);
        user.delete(3);
        user.update(1, "d1", -1, null);
        user.display();

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
        Formatter formatter = new Formatter();
        Handler fileHandler = null;

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
}
