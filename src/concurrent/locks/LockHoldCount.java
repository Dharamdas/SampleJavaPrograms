package concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

public class LockHoldCount implements Runnable{
    
	ReentrantLock lock;
    public LockHoldCount(ReentrantLock lock) { 
        this.lock=lock;
    }
    
    public void run(){
        
                  System.out.println(Thread.currentThread().getName()
               +" is Waiting to acquire lock");
 
        
        lock.lock();
        System.out.println();
        System.out.println(Thread.currentThread().getName()
                     +" has called lock(), lockHoldCount = "+lock.getHoldCount());
        
        
        lock.lock();         
        System.out.println(Thread.currentThread().getName()
                     +" has called lock(), lockHoldCount= "+lock.getHoldCount());
        
        System.out.println(Thread.currentThread().getName()
                  +" is about to call unlock(), lockHoldCount will become=  "+lock.getHoldCount());
           lock.unlock();    
        
        System.out.println(Thread.currentThread().getName()
                  +" is about to call unlock(), lockHoldCount will become= "+lock.getHoldCount());
           lock.unlock();    
        
        
        
    }

}
