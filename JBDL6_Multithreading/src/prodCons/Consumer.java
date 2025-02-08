package prodCons;

public class Consumer extends Thread{

    SharedData sharedData;

    Consumer(SharedData sharedData){
        this.sharedData = sharedData;
    }

    public void run(){
        for (int i=1;i<=10;i++){
            sharedData.consume();
        }
    }
}
