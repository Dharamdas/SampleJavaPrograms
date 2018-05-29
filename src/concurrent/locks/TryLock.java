package concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class TryLock implements Runnable{

	Lock lock;
	TryLock(Lock lock)
	{
		this.lock=lock;
	}
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()
                +" is Waiting to acquire lock");
		try {
			
			if(lock.tryLock(15000,TimeUnit.MILLISECONDS))
			{
				System.out.println(Thread.currentThread().getName()
			            +" has acquired lock.");
				Thread.sleep(1000);
			}else{
				 System.out.println(Thread.currentThread().getName()
			             +" didn't got lock.");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
