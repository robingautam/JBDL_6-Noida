package hashcodeequals;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person(1, "Robin");
        Person person2 = new Person(1, "Robin");
        //Person person3 = new Person(2, "Robin");

        System.out.println(person1.equals(person2));
       // System.out.println(person1.equals(person3));


        Map<Person,Integer> map = new HashMap<>();
        map.put(person1,1);
        map.put(person2,2);
      //  map.put(person3,3);

        System.out.println(map.size());
    }
}
