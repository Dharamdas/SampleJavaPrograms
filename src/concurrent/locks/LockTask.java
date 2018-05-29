package concurrent.locks;

import java.util.concurrent.locks.Lock;

public class LockTask implements Runnable {

	Lock lock;
	LockTask(Lock lock)
	{
		this.lock=lock;
	}
	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName()
                +" is Waiting to acquire lock");
		lock.lock();
		
		try{
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()
                    +" is sleeping.");
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		 System.out.println(Thread.currentThread().getName()
                 +" has released lock.");
		lock.unlock();
		
	}
	
	
}
