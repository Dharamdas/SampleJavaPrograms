package concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

public class LockHoldCountTest {

	public static void main(String[] args) {

		ReentrantLock lock=new ReentrantLock();
		LockHoldCount myRunnable=new LockHoldCount(lock);
        new Thread(myRunnable,"Thread-1").start();
        new Thread(myRunnable,"Thread-2").start();
	}

}
