package prodCons;

public class Producer extends Thread{

    SharedData sharedData;

    Producer(SharedData sharedData){
        this.sharedData = sharedData;
    }

    public void run(){
        for (int i=1;i<=10;i++){
            sharedData.produce(i);
        }
    }
}
