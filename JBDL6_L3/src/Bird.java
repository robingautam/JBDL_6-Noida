public interface Bird {

     void eat();
     void walk();
     void fly();

     default void defaultMethod(){
         addBird();
         System.out.println("This is default method");
     }

     private void addBird(){
         System.out.println("This is private method");
     }

}
