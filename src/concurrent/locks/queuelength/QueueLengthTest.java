package concurrent.locks.queuelength;

import java.util.concurrent.locks.ReentrantLock;

public class QueueLengthTest {

	public static void main(String[] args) {

		ReentrantLock lock=new ReentrantLock();
		QueueLength myRunnable=new QueueLength(lock);
        new Thread(myRunnable,"Thread-1").start();
        new Thread(myRunnable,"Thread-2").start();
        new Thread(myRunnable,"Thread-3").start();
	}

}
