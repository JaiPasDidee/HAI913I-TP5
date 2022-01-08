package ecommerce;

import java.util.Calendar;

public class Product {

    int id;
    String name;
    int price;
    Calendar expiration_date;

    public Product(int id, String name, int price, Calendar expiration_date) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Calendar getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Calendar expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expiration_date=" + expiration_date +
                '}';
    }
}
