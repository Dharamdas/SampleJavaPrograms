package concurrent.threadpool.mythreadpool;

import java.util.concurrent.LinkedBlockingDeque;

public class CustomtThreadPool {
	
	private LinkedBlockingDeque<Runnable> taskQueue;
	private boolean poolShutdownInitiated=false;
	
	CustomtThreadPool(int nthreads)
	{
		taskQueue = new LinkedBlockingDeque<Runnable>(nthreads);
		for(int i=1;i<=nthreads;i++)
		{
			PoolsThreadExecution pools = new PoolsThreadExecution(taskQueue, this);
			pools.setName("Thread-"+i);
			pools.start();
		}
	}
	
	public synchronized void   execute(Runnable task)throws Exception
	{
		if(isPoolShutdownInitiated())
			throw new Exception("Given task is null");
		
		this.taskQueue.put(task);
	}
	
	public boolean isPoolShutdownInitiated()
	{
		return poolShutdownInitiated;
	}
	public void shutDown()
	{
		this.poolShutdownInitiated=true;
		System.out.println("Pool ShutdownInitiated:::::");
		
	}

}
