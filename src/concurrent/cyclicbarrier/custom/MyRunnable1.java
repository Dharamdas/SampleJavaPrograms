package concurrent.cyclicbarrier.custom;

public class MyRunnable1 implements Runnable{

CyclicBarrierCustom cyclicBarrierCustom;
    
    MyRunnable1(CyclicBarrierCustom cyclicBarrierCustom){
           this.cyclicBarrierCustom=cyclicBarrierCustom;
    }
    
    @Override
    public void run() {
           
           System.out.println(Thread.currentThread().getName() +
                        " is waiting for all other threads to reach common barrier point");
 
           try {
                  Thread.sleep(1000);
                  /*
                   * when all 3 parties will call await() method (i.e. common barrier point)
                   * CyclicBarrrierEvent will be triggered and all waiting threads will
                   * be released.
                   */
 
                  cyclicBarrierCustom.await();
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println("As all threads have reached common barrier point "
                        + Thread.currentThread().getName() +
                        " has been released");
    }

}
class CyclicBarrrierEvent implements Runnable {

    public void run() {
        System.out.println("As all threads have reached common barrier point "
                + ", CyclicBarrrierEvent has been triggered");
    }
}
