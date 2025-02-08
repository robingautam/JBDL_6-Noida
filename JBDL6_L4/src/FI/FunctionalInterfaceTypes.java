package FI;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceTypes {

    public static void main(String[] args) {
        // Predicate

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
               return integer%2==1;
            }
        };

        System.out.println(predicate.test(4));


       /* Function<Integer,Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        };

        System.out.println(function.apply(2));*/


      /*  Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
              return new Random().nextInt();
            }
        };

        System.out.println(supplier.get());*/


     /*   Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Integer: "+integer);
            }
        };

        consumer.accept(12);*/



    }
}
