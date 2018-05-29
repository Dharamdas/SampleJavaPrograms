package concurrent.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorWithRunnableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		final int nThread = 2;
		final int nTask = 10;
		
		ExecutorService executor = Executors.newFixedThreadPool(nThread);
		System.out.println("executor created with 2 threads.");
        
        System.out.println("2 threads in executor will be used for executing 10 tasks. "
                     + "So, at a time only 2 tasks will be executed");
		for(int i=0;i<nTask;i++)
		{
			ExecutorWithRunnable task = new ExecutorWithRunnable(i);
			executor.submit(task);
		}
		
		ExecutorWithRunnable task = new ExecutorWithRunnable(10);
		Future<Integer> f = executor.submit(task,10);
		System.out.println("Runnable Task Result: "+f.get());
		
		executor.shutdown();
		System.out.println("executor End");

	}

}
