package synchronization;

public class NumberThree extends Thread{

    Table table;

    NumberThree(Table table){
        this.table = table;
    }

    public void run(){
        table.printTable(3);
    }
}
