package utils;
public class Command {
    java.util.Map<java.lang.Integer, utils.Product> products;

    public Command(java.util.Map<java.lang.Integer, utils.Product> products) {
        this.products = products;
    }

    // display products in a repository, where every product has an ID, a
    // name, a price, and a expiration date
    public void display() {
        java.lang.System.out.println(products.toString());
    }

    // fetch a product by its ID (if no product with the provided ID exists,
    // an exception must be thrown).
    public void fetch(int id) throws java.lang.Exception {
        utils.Product result = null;
        for (utils.Product product : products.values()) {
            if (product.id == id)
                result = product;

        }
        if (result == null)
            java.lang.System.out.println("pas bon");

        // throw new Exception("There is no product with this id");
    }

    // add a new product (if a product with the same ID already exists, an
    // exception must be thrown)
    public void add(utils.Product product) throws java.lang.Exception {
        if (products.containsKey(product.id))
            java.lang.System.out.println("pas bon2");
        else// throw new Exception("this Id already exist");

            products.put(product.id, product);

    }

    // delete a product by its ID (if no product with the provided ID exists,
    // an exception must be thrown).
    public void delete(int id) throws java.lang.Exception {
        if (products.containsKey(id))
            products.remove(id, products.get(id));
        else
            java.lang.System.out.println("pas bon 3");

        // throw new Exception("This product doesn't exist");
    }

    // update a product’s info (if no product with the provided ID exists,
    // an exception must be thrown)
    public void update(int id, java.lang.String name, int price, java.util.Calendar expiration_date) throws java.lang.Exception {
        if (products.containsKey(id)) {
            utils.Product new_value = products.get(id);
            utils.Product old = products.get(id);
            if (name != null)
                new_value.setName(name);

            if (price != (-1))
                new_value.setPrice(price);

            if (expiration_date != null)
                new_value.setExpiration_date(expiration_date);

            products.replace(old.id, old, new_value);
        } else
            java.lang.System.out.println("pas bon 4");

        // throw new Exception("Cant replace there is no product with this id");
    }
}