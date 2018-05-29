package threads.synchronization;

public class ObjectLockDemo {

	public static void main(String args[]) throws InterruptedException{
        
		ObjectLock myRunnable1=new ObjectLock();
        
        Thread thread1=new Thread(myRunnable1,"Thread-1");
        Thread thread2=new Thread(myRunnable1,"Thread-2");
        thread1.start();        
        Thread.sleep(10);//Just to ensure Thread-1 starts before Thread-2
        thread2.start();        
        
        
 }

}
