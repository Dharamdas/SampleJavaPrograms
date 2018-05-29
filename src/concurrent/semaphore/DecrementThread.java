package concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class DecrementThread implements Runnable{

	Semaphore semaphore;
    public DecrementThread(Semaphore s){
           semaphore=s;
    }
    
    public void run(){
           System.out.println(Thread.currentThread().getName()+
                        " is waiting for permit");
           
           try {
                  semaphore.acquire();
                  System.out.println(Thread.currentThread().getName()+
                               " has got permit");
           
                  for(int i=0;i<5;i++){          
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+
                                      " > "+SemaphoreTest.SharedValue--);
                  }
                  
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           
           
           System.out.println(Thread.currentThread().getName()+
                        " has released permit");
           semaphore.release();

}
}
