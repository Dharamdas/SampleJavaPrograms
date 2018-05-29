package concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	
	static int SharedValue=0;
    
    public static void main(String[] args) {
           Semaphore semaphore=new Semaphore(1); 
           System.out.println("Semaphore with 1 permit has been created");

           
           IncrementThread incrementThread=new IncrementThread(semaphore);
           new Thread(incrementThread,"incrementThread").start();
           
           DecrementThread decrementThread=new DecrementThread(semaphore);
           new Thread(decrementThread,"decrementThread").start();
           
    }
}
