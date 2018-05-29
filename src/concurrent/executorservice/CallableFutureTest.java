package concurrent.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		final int nThread = 10;
		
		ExecutorService executor  = Executors.newFixedThreadPool(nThread);
		
		Future<Integer> f1 = executor.submit(new SumIntegerCallable(10));
		Future<Double> f2 = executor.submit(new SquareDoubleCallable(10d));
		
		System.out.println("Callable Executed Integer Sum Result: "+f1.get());
		System.out.println("Callable Executed Double squre Result: "+f2.get());
		executor.shutdown();
		System.out.println("Executor End");
	}

}
