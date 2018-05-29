package concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {

	public static void main(String[] args) {

		 Lock lock=new ReentrantLock();
		 TryLock myRunnable=new TryLock(lock);
         new Thread(myRunnable,"Thread-1").start();
         new Thread(myRunnable,"Thread-2").start();
         
	}

}
