package ecommerce;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger primaryKey = new AtomicInteger(0);
    private int id;
    private String name;
    private String email;
    private String password;
    private int age;

    public User(String name, String email, String password, int age) {
        id = primaryKey.incrementAndGet();
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        String json = "{ \"id\": %d, \"name\": \"%s\", \"email\": \"%s\", \"age\": %d }";

        return String.format(json, id, name, email, age);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { this.age = age; }
}
