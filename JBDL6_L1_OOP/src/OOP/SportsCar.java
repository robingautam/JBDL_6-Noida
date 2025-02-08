package OOP;

public class SportsCar extends NormalCar{

    String heavyEngine;
    String safety;

    SportsCar(){
        super();
        super.someMethodforSuper();
    }


   @Override
    public void someMethod() {
       super.someMethodforSuper();
        System.out.println("This is sport car override");
    }
}
