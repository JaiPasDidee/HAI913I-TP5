package utils;
public class User {
    int id;

    java.lang.String name;

    java.lang.String email;

    java.lang.String password;

    int age;

    utils.Command command;

    public User(int id, java.lang.String name, java.lang.String email, java.lang.String password, int age, utils.Command command) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.command = command;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((((((((((((("utils.User{" + "id=") + id) + ", name='") + name) + '\'') + ", email='") + email) + '\'') + ", password='") + password) + '\'') + ", age=") + age) + '}';
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

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // display products in a repository, where every product has an ID, a
    // name, a price, and a expiration date
    public void display() {
        command.display();
    }

    // fetch a product by its ID (if no product with the provided ID exists,
    // an exception must be thrown).
    public void fetch(int id) throws java.lang.Exception {
        command.fetch(id);
    }

    // add a new product (if a product with the same ID already exists, an
    // exception must be thrown)
    public void add(utils.Product product) throws java.lang.Exception {
        command.add(product);
    }

    // delete a product by its ID (if no product with the provided ID exists,
    // an exception must be thrown).
    public void delete(int id) throws java.lang.Exception {
        command.delete(id);
    }

    // update a product’s info (if no product with the provided ID exists,
    // an exception must be thrown)
    public void update(int id, java.lang.String name, int price, java.util.Calendar expiration_date) throws java.lang.Exception {
        command.update(id, name, price, expiration_date);
    }
}