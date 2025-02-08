package OOP;

public class NormalCar {

    String name;
    String color;
    String fuelTank;


    public void someMethod(){
        System.out.println("this is some method");
    }

    public void someMethodforSuper(){
        this.name="some data";
        System.out.println("this is some method");
    }
}
