package concurrent.executorservice;

import java.util.concurrent.Callable;

public class SquareDoubleCallable implements Callable<Double> {
 
    Double n;
 
    SquareDoubleCallable(Double n) {
           this.n = n;
    }
 
    @Override
    public Double call() throws Exception {
           return n*n;
    }

}
