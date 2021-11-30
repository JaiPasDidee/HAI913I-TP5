public class Product {
    int id;

    java.lang.String name;

    int price;

    java.util.Calendar expiration_date;

    public Product(int id, java.lang.String name, int price, java.util.Calendar expiration_date) {
        System.out.println("Enter in the method <init> from class Product");;
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiration_date = expiration_date;
    }

    public int getId() {
        System.out.println("Enter in the method getId from class Product");;
        return id;
    }

    public void setId(int id) {
        System.out.println("Enter in the method setId from class Product");;
        this.id = id;
    }

    public java.lang.String getName() {
        System.out.println("Enter in the method getName from class Product");;
        return name;
    }

    public void setName(java.lang.String name) {
        System.out.println("Enter in the method setName from class Product");;
        this.name = name;
    }

    public int getPrice() {
        System.out.println("Enter in the method getPrice from class Product");;
        return price;
    }

    public void setPrice(int price) {
        System.out.println("Enter in the method setPrice from class Product");;
        this.price = price;
    }

    public java.util.Calendar getExpiration_date() {
        System.out.println("Enter in the method getExpiration_date from class Product");;
        return expiration_date;
    }

    public void setExpiration_date(java.util.Calendar expiration_date) {
        System.out.println("Enter in the method setExpiration_date from class Product");;
        this.expiration_date = expiration_date;
    }

    @java.lang.Override
    public java.lang.String toString() {
        System.out.println("Enter in the method toString from class Product");;
        return ((((((((("Product{" + "id=") + id) + ", name='") + name) + '\'') + ", price=") + price) + ", expiration_date=") + expiration_date) + '}';
    }
}