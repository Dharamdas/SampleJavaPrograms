package concurrent.executorservice;

import java.util.concurrent.Callable;

public class SumIntegerCallable implements Callable<Integer> {
 
    Integer n;
 
    SumIntegerCallable(Integer n) {
           this.n = n;
    }
 
    @Override
    public Integer call() throws Exception {
           Integer sum = 0;
           for (int i = 0; i <= n; i++) {
                  sum += i;
           }
           return sum;
    }

}
