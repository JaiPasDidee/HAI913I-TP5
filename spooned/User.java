public class User {
    int id;

    java.lang.String name;

    java.lang.String email;

    java.lang.String password;

    int age;

    public User(int id, java.lang.String name, java.lang.String email, java.lang.String password, int age) {
        System.out.println("Enter in the method <init> from class User");;
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    @java.lang.Override
    public java.lang.String toString() {
        System.out.println("Enter in the method toString from class User");;
        return ((((((((((((("User{" + "id=") + id) + ", name='") + name) + '\'') + ", email='") + email) + '\'') + ", password='") + password) + '\'') + ", age=") + age) + '}';
    }

    public int getId() {
        System.out.println("Enter in the method getId from class User");;
        return id;
    }

    public void setId(int id) {
        System.out.println("Enter in the method setId from class User");;
        this.id = id;
    }

    public java.lang.String getName() {
        System.out.println("Enter in the method getName from class User");;
        return name;
    }

    public void setName(java.lang.String name) {
        System.out.println("Enter in the method setName from class User");;
        this.name = name;
    }

    public java.lang.String getEmail() {
        System.out.println("Enter in the method getEmail from class User");;
        return email;
    }

    public void setEmail(java.lang.String email) {
        System.out.println("Enter in the method setEmail from class User");;
        this.email = email;
    }

    public java.lang.String getPassword() {
        System.out.println("Enter in the method getPassword from class User");;
        return password;
    }

    public void setPassword(java.lang.String password) {
        System.out.println("Enter in the method setPassword from class User");;
        this.password = password;
    }

    public int getAge() {
        System.out.println("Enter in the method getAge from class User");;
        return age;
    }

    public void setAge(int age) {
        System.out.println("Enter in the method setAge from class User");;
        this.age = age;
    }
}