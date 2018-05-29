package concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutures {
	private static final int NTHREDS = 5;
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(NTHREDS);
		Executors.newCachedThreadPool();
		
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		
		for(int i=0;i<5;i++)
		{
			Callable<Long> worker= new MyCallable();
			Future<Long> submit = executorService.submit(worker);
			try {
				System.out.println("............."+submit.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(submit);
		}
		
		long sum=0;
		System.out.println("Row Retrived the Result: "+list.size());
		
		for(Future<Long> future : list)
		{
			try{
				sum = sum+future.get();
				
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Total Sum is: "+sum);
		executorService.shutdown();
		//executorService.awaitTermination();
	}
}
