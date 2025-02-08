package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GenericHelper<String,Integer> genericHelper = new GenericHelper<>();
        genericHelper.someMethod("",2);

        // collection

        List list  = new ArrayList();
        list.add(1);
        list.add("Robin");
        list.add('a');



    }
}
