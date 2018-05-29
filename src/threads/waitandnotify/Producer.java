package threads.waitandnotify;

import java.util.Vector;

public class Producer extends Thread{
	
	private Vector sharedQueue;
	private int qSize;
	
	public Producer(Vector sharedQueue,int qSize) {
		this.sharedQueue=sharedQueue;
		this.qSize=qSize;
	}
	
	public void run()
	{
		
		try{
			for(int i=1;i<=20;i++)
			{
					produce(i);
					sleep(1000);
					if(i==20)
						i=0;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void produce(int i)throws Exception
	{
		
		synchronized (sharedQueue) {
			while(sharedQueue.size()==qSize)
			{
					System.out.println(currentThread().getName()+" sharedQueue is Full!!! sharedQueue Size is "+sharedQueue.size());
					sharedQueue.wait();
			}
		}
		
		
		synchronized (sharedQueue) {
		
			sharedQueue.add(i);
			System.out.println(currentThread().getName()+" Produced "+i);
			sharedQueue.notifyAll();
		}
		
	}
}
