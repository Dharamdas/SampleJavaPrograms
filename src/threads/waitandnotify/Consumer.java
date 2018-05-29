package threads.waitandnotify;

import java.util.Vector;

public class Consumer extends Thread{

	private Vector sharedQueue;
	private int qsize;
	
	public Consumer(Vector v,int size) {
		this.sharedQueue=v;
		this.qsize=size;
	}
	
	
	public void run()
	{
		while(true)
		{
		  try {
				System.out.println(currentThread().getName()+" Consume "+consume());
				sleep(1000);
			} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	private int consume()throws Exception
	{
		synchronized (sharedQueue) {
			while(sharedQueue.size()==0)
			{
				System.out.println(currentThread().getName()+" Queue is Empty Please wait !!! Queue Size is "+sharedQueue.size());
				sharedQueue.wait();
			}
		}
		synchronized (sharedQueue) {
			sharedQueue.notifyAll();
			return  (Integer) sharedQueue.remove(0);
		}
	}
}
