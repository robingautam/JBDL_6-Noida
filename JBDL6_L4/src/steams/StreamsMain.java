package steams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsMain {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,5,23,56,12,45,67);

        // find the odd numbers

        List<Integer> ans = new ArrayList<>();

        for (int i=0;i<list.size();i++){
            int val = list.get(i);
            if (val%2==1){
                ans.add(val);
            }
        }

       // System.out.println(ans);

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==1;
            }
        };
        // odd numbers find
    //    List<Integer> sans = list.stream().filter(predicate).collect(Collectors.toList());
        //List<Integer> sans = list.stream().filter(i->i%2==1).collect(Collectors.toList());


        //System.out.println(sans);

        /** square the numbers in a list**/

        List<Integer> square = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            int val = list.get(i);
            square.add(val*val);

        }

       // System.out.println(square);

       /* Function<Integer,Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        };*/
     /*   square = list.stream().map(i->i*i).collect(Collectors.toList());

        System.out.println(square);*/


        System.out.println(list.stream().findAny().get());


    }
}
