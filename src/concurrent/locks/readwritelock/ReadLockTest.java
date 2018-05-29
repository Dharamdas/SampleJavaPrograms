package concurrent.locks.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadLockTest {

    public static void main(String...args)
    {
        //System.out.println("Starting Thread Programs");

        ReadWriteLock lock = new ReentrantReadWriteLock();
        ReadLockRunnable run = new ReadLockRunnable(lock);
        new Thread(run,"Thread-1").start();
        new Thread(run,"Thread-2").start();
        new Thread(run,"Thread-3").start();
        new Thread(run,"Thread-4").start();

      //  System.out.println("End Thread Programs");
    }
}
class ReadLockRunnable implements Runnable{
    ReadWriteLock readWriteLock;

    ReadLockRunnable(ReadWriteLock readWriteLock){
        this.readWriteLock=readWriteLock;
    }

    public void run()
    {

        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " Thread has aquired the lock");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + " Thread has released the lock");
            readWriteLock.readLock().unlock();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}