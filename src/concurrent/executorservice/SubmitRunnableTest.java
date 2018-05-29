package concurrent.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 final int NTHREDS = 10;
	    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
	 
	    Future<Integer> futureInteger=executor.submit(new MyRunnable(), 1);
	    System.out.println("futureInteger.get() > "+futureInteger.get());
	     
	    Future<?> future=executor.submit(new MyRunnable());
	    System.out.println("future.get() > "+future.get());
	    executor.shutdown();
	  }
}
