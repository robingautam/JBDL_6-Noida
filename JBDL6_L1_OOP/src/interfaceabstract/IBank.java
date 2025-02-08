package interfaceabstract;

public interface IBank {

      void someMethod_1();
     void someMethod_2();

     void someMethod_3();

     default void someDefaultMethod(){
         somePrivateMethod();
         System.out.println("This is default method");
     }

    private int somePrivateMethod(){ // utility method or helper method
         return 2+3;
    }
}
