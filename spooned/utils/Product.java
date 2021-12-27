package utils;
public class Product {
    int id;

    java.lang.String name;

    int price;

    java.util.Calendar expiration_date;

    public Product(int id, java.lang.String name, int price, java.util.Calendar expiration_date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiration_date = expiration_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public java.util.Calendar getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(java.util.Calendar expiration_date) {
        this.expiration_date = expiration_date;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((((((((("utils.Product{" + "id=") + id) + ", name='") + name) + '\'') + ", price=") + price) + ", expiration_date=") + expiration_date) + '}';
    }
}