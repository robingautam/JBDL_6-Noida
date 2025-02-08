package OOP;

public class Person {

    String name;
    String email;
    String address;
   private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){
            return;
        }
        this.age = age;
    }

    Person(){}

    Person(String address){
        this.address = address;
    }

     Person(String n, String e){
        this("M.V");
        this.name = n;
        this.email = e;
    }

    public void eat(){
        System.out.println("I can eat");
    }
    public void sleep(){
        System.out.println("I can sleep");
    }
}
