package ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger primaryKey = new AtomicInteger(0);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @JsonProperty("id")
    private final int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private int price;
    @JsonIgnore
    private LocalDate expirationDate;

    public Product() {
        id = primaryKey.incrementAndGet();
    }

    public Product(String name, int price, LocalDate expirationDate) {
        id = primaryKey.incrementAndGet();
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        String json = "{ \"id\": %d, \"name\": \"%s\", \"price\": %d }";

        return String.format(json, id, name, dtf.format(expirationDate), price);
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
