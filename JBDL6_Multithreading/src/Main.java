public class Main {
    public static void main(String[] args) throws InterruptedException {

       /* MyThread thread = new MyThread();
        thread.start();

        for (int i=1;i<=10;i++){
            System.out.println(i+" "+Thread.currentThread().getName());
        }

        MyThread myThread2 = new MyThread();
        myThread2.start();*/

       /* ArithTest arithTest = new ArithTest();
        arithTest.run();*/

        MyThread myThread = new MyThread();
        myThread.start();

        myThread.join();

        System.out.println("Inside the main thread");


    }
}

class MyThread extends Thread{

    @Override
    public void run(){
       for (int i=1;i<=10;i++){
           System.out.println(i+" "+Thread.currentThread().getName());
           try {
               this.join();
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }
}

class ArithTest extends Thread {
    @Override
    public void run(){
        int c = 10/0;
    }

}