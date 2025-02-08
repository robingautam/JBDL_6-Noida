package synchronization;

public class NumberTwo extends Thread{

    Table table;

    NumberTwo(Table table){
        this.table = table;
    }

    public void run(){
        table.printTable(2);
    }
}
