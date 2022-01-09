package ecommerce;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger primaryKey = new AtomicInteger(0);
    @JsonProperty("id")
    private final int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private int price;

    public Product() {
        id = primaryKey.incrementAndGet();
    }

    public Product(String name, int price) {
        id = primaryKey.incrementAndGet();
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        String json = "{ \"id\": %d, \"name\": \"%s\", \"price\": %d }";

        return String.format(json, id, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Product))
            return false;

        return ((Product) o).getId() == id;
    }

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
