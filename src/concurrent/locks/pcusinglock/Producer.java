package concurrent.locks.pcusinglock;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {

	List<Integer> sharedQueue=null;
	int maxSize=2; // number of product queue can hold
	Lock lock;
	Condition produceCondition;
	Condition consumerCondition;
	public Producer(List<Integer> sharedList,Lock lock, Condition proCondition,Condition consumerCondition) 
	{
		this.sharedQueue=sharedList;
		this.lock=lock;
		this.produceCondition=proCondition;
		this.consumerCondition=consumerCondition;
	}
	
	@Override
	public void run() {

		for(int i=0;i<10;i++)
		{
			try{
				producer(i);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void producer(int value)throws InterruptedException
	{
		lock.lock();
			if(sharedQueue.size()==maxSize)
				produceCondition.await();
			
			System.out.println("Produced: "+value);
			
		sharedQueue.add(value);
		consumerCondition.signal();
		
		lock.unlock();
	}
		
		
}
	
	
