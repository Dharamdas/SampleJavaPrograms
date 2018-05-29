package concurrent.threadpool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
	 
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
 
    }
 
}

 class WorkerThread implements Runnable{
	 private String command;
     
	    public WorkerThread(String s){
	        this.command=s;
	    }
	 
	    @Override
	    public void run() {
	        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
	        processCommand();
	        System.out.println(Thread.currentThread().getName()+" End.  Command = "+command);
	    }
	 
	    private void processCommand() {
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    @Override
	    public String toString(){
	        return this.command;
	    }
}
