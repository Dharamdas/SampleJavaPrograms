package concurrent.naturalnumber;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Worker implements Runnable {

	BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>(); 
    Worker next = null; // next worker in the chain
    
    public void setNext(Worker next) {
		this.next = next;
	}
    
    public void accept(int i) {
        q.add(i);
    }
    
	@Override
	public void run() {

		 while (true){
	            try {
	                int i = q.take(); // blocks till it receives a number
	                
	                System.out.println( Thread.currentThread().getName() +  i);
	                
	                Thread.sleep(1000); // delay to slow the printing
	                if (next != null){
	                    next.accept(i+1); // pass the next number to the next worker 
	                }
	 
	            } catch (InterruptedException e) {
	                System.err.println( Thread.currentThread().getName() + " interrrupted.");
	            }
	        }
	}

}
