import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = scanner.nextInt();

      /* if (num%2==0){
           System.out.println("This is even number");
       }else {
           System.out.println("This is Odd Number");
       }*/

      /*  Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };

        boolean ans = predicate.test(num);
        if (ans){
            System.out.println("This is even number");
        }else {
            System.out.println("This is Odd Number");
        }*/
    }
}