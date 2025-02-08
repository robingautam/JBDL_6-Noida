package synchronization;

public class NBThread extends Thread{
    Person person;

    NBThread(Person person){
        this.person = person;
    }

    public void run(){
        person.withdraw(400);
    }
}
