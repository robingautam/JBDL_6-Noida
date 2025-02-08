package prodCons;

public class SharedData {

    private int data;
    private boolean isProduced=false;

    public synchronized void produce(int val) {
        if (isProduced==true){
            try {
                wait();
            }
            catch (Exception ex){


            }
        }
        this.data = val;
        isProduced = true;
        System.out.println("Produced: "+val);
        notify();
    }

    public synchronized void consume(){
        if (isProduced==false){
            try {
                wait();
            }
            catch (Exception ex){


            }
        }
        isProduced = false;
        System.out.println("consumed: "+this.data);
        notify();
    }
}
