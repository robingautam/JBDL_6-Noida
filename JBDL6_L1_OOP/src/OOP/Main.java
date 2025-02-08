package OOP;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
     //   Person robin = new Person("robin", "robin@gmail.com");

      /*  Student student1 = new Student(1,"Robin","robin@gmail.com");
        Student student2 = new Student(2,"preeti","preeti@gmail.com");

        Student.collegeName="MAIT";*/
     //   int ans = getInt();


       /* Student student = new Student(12, "Robin","robin@gmail.com");

        System.out.println(student);
        */

        // name field is coming from normalcar class
        SportsCar sportsCar = new SportsCar();
        sportsCar.name = "sports car";

        // why encapsulation

        Person person = new Person();
        person.setAge(-18);
        System.out.println(person.getAge());

        List<Integer> list = new ArrayList<>();
        list.add(23);


    }

    // method return type

    // data types are the return type.
    // If we are not going to return anything them we have to make a method as void

    public static int getInt(){
       int a = 12;
       return a;
    }

    public static char getChar(){
        char a = 'a';
        return a;
    }
}
