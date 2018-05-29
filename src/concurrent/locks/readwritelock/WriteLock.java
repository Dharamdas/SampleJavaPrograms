package concurrent.locks.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteLock {

    public static void main(String...agrs)
    {
        ReadWriteLock writeLock = new ReentrantReadWriteLock();
        WriteLockRunnable writeLockRunnable= new WriteLockRunnable(writeLock);

        new Thread(writeLockRunnable,"Thread-1").start();
        new Thread(writeLockRunnable,"Thread-2").start();
        new Thread(writeLockRunnable,"Thread-3").start();
        new Thread(writeLockRunnable,"Thread-4").start();
    }
}


class WriteLockRunnable implements Runnable{

    ReadWriteLock writeLock;

    WriteLockRunnable(ReadWriteLock writeLock)
    {
        this.writeLock=writeLock;
    }
    public void run(){

        try{

            writeLock.writeLock().lock();

            System.out.println(Thread.currentThread().getName()+" is obtained the Write lock");

            Thread.sleep(10000);

            System.out.println(Thread.currentThread().getName()+" is releasing the Write lock");

            writeLock.writeLock().unlock();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
