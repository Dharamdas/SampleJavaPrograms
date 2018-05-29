package concurrent.threadpool.mythreadpool;

import java.util.concurrent.LinkedBlockingDeque;

public class PoolsThreadExecution extends Thread{
	
	private LinkedBlockingDeque<Runnable> taskQueue;
	private CustomtThreadPool pool;
	
	PoolsThreadExecution(LinkedBlockingDeque<Runnable> taskQueue,CustomtThreadPool pool)
	{
		this.taskQueue=taskQueue;
		this.pool = pool;
	}
	
	
	public void run()
	{
		
		while(true)
		{
			System.out.println("Thread Started--------- "+Thread.currentThread().getName());
			
			
			try {
				System.out.println("REciving task from Queue");
				Runnable run = taskQueue.take();
				System.out.println("task taken from Queue");
				run.run(); // this is the class which execute the business logic
				System.out.println("Task has been executed");
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			
			
			if(pool.isPoolShutdownInitiated() || taskQueue.size()==0)
			{
				try{
				System.out.println("either there is no task in the queue or shuddown has been initiated");
				Thread.interrupted();
				Thread.sleep(1000);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		}
		
		
	}
}
