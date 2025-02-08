package synchronization;

public class Main {

    public static void main(String[] args) throws InterruptedException {
       /* Table table = new Table();
        NumberTwo t1 = new NumberTwo(table);
        NumberThree t2 = new NumberThree(table);

        t1.start();
        t2.start();*/

        Person person = new Person();
        person.setBalance(1000);

        ATMThread t1 = new ATMThread(person);
        NBThread t2 = new NBThread(person);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Balance: "+person.getBalance());
    }
}
