package runnable;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Inside the call method");
        return 1;
    }
}
