package synchronization;

public class Person {

    double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public synchronized void  withdraw(int amount){
        this.balance = this.balance-amount;
        try {
            Thread.sleep(500);
        }
        catch (Exception exception){

        }
        printBalance(this.balance);
    }

    private void printBalance(double balance){
        System.out.println("balance: "+balance);
    }
}
