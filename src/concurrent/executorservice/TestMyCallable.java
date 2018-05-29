package concurrent.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestMyCallable {

	public static void main(String[] args) {

		MyCallable cal1 = new MyCallable(10000);
		MyCallable cal2 = new MyCallable(10000);
		
		//creating future task
		FutureTask<String> f1 = new FutureTask<String>(cal1);
		FutureTask<String> f2 = new FutureTask<String>(cal2);
		
		//creating thread pool
		//Executors.newCachedThreadPool()
	//	Executors.newFixedThreadPool(nThreads)
		//Executors.newScheduledThreadPool(corePoolSize)
	//	Executors.newSingleThreadExecutor()
	//	Executors.newSingleThreadExecutor(threadFactory)
	//	Executors.newSingleThreadScheduledExecutor()
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(f1);
		executor.execute(f2);
		
		
		
		while(true)
		{
			try{
			if(f1.isDone() && f2.isDone())
			{
				System.out.println("Tasks are executed...");
				executor.shutdown();
				return;
			}
			if(f1.isDone()){
				//wait indefinatly for future taks to complete
				System.out.println("Future task output: "+f1.get());
				break;
			}
			//wating for the future task2 to complete
			System.out.println("Future task 2"+f2.get(200L,TimeUnit.MICROSECONDS));
				
		}catch (InterruptedException | ExecutionException  e) {
			e.printStackTrace();
		}catch (TimeoutException e) {
			System.out.println("Time out Error");
		}
	}
}
}	

