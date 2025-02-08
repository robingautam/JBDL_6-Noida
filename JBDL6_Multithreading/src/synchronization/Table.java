package synchronization;

public class Table {

    public  void printTable(int num){
        synchronized(this) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + "*" + i + "=" + (num * i));
            }
        }
    }
}
