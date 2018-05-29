package concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyRunnable implements Runnable{

	private CyclicBarrier  cy;
	MyRunnable(CyclicBarrier cy)
	{
		this.cy=cy;
	}
	@Override
	public void run() {
		 System.out.println(Thread.currentThread().getName() +
                 " is waiting for all other threads to reach common barrier point");

		 try {
             Thread.sleep(1000);
             /*
              * when all 3 parties will call await() method (i.e. common barrier point)
              * CyclicBarrrierEvent will be triggered and all waiting threads will be released.
              */
             cy.await();
		 } catch (InterruptedException e) {
             e.printStackTrace();
		 } catch (BrokenBarrierException e) {
             e.printStackTrace();
      }          
      
      System.out.println("As all threads have reached common barrier point "
                   + Thread.currentThread().getName() +
                   " has been released");
		
	}

}
class CyclicBarrrierEvent implements Runnable{
	 
    public void run() {
           System.out.println("As all threads have reached common barrier point "
                        + ", CyclicBarrrierEvent has been triggered");
    }
    
}