package synchronization;

public class ATMThread extends Thread{

    Person person;

    ATMThread(Person person){
        this.person = person;
    }

    public void run(){
        person.withdraw(200);
    }
}
