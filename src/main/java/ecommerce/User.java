package ecommerce;

import java.util.Calendar;

public class User {

    int id;
    String name;
    String email;
    String password;
    int age;
    Order order;

    public User(int id, String name, String email, String password, int age, Order order) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.order = order;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //display products in a repository, where every product has an ID, a
    //name, a price, and a expiration date
    public void display(){
        order.display();
    }

    //fetch a product by its ID (if no product with the provided ID exists,
    //an exception must be thrown).
    public void fetch(int id) {
        order.fetch(id);
    }

    //add a new product (if a product with the same ID already exists, an
    //exception must be thrown)
    public void add (Product product) {
        order.add(product);
    }

    //delete a product by its ID (if no product with the provided ID exists,
    //an exception must be thrown).
    public void delete(int id) {
        order.delete(id);
    }

    //update a product’s info (if no product with the provided ID exists,
    //an exception must be thrown)
    public void update(int id, String name, int price, Calendar expiration_date) {
        order.update(id,name, price, expiration_date);
    }
}