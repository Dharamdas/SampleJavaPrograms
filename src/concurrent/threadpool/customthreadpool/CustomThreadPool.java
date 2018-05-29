package concurrent.threadpool.customthreadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

	private BlockingQueue<Runnable> taskQueue;
	private boolean poolShutDownInitiated = false;
	
	public CustomThreadPool(int nThreads){
        taskQueue = new LinkedBlockingQueue<Runnable>(nThreads);
 
        //Create and start nThreads number of threads.
        for(int i=1; i<=nThreads; i++){
           ThreadPoolsThread threadPoolsThread=new ThreadPoolsThread(taskQueue,this);
         threadPoolsThread.setName("Thread-"+i);
         System.out.println("Thread-"+i +" created in ThreadPool.");
         threadPoolsThread.start();   //start thread
        }
       
    }
	
	
	 /**
     * Execute the task, task must be of Runnable type.
     */
    public synchronized void  execute(Runnable task) throws Exception
    {
        if(this.poolShutDownInitiated)
           throw new Exception("ThreadPool has been shutDown, no further tasks can be added");
 
        /*
      * Add task in sharedQueue,
      * and notify all waiting threads that task is available.  
            */
        System.out.println("task has been added.");
        this.taskQueue.put(task);
    }
    
    
    
	
	  public boolean isPoolShutDownInitiated() {
          return poolShutDownInitiated;
   }
	  /**
	     * Initiates shutdown of ThreadPool, previously submitted tasks
	     * are executed, but no new tasks will be accepted.
	     */
	  public synchronized void shutdown(){
	       this.poolShutDownInitiated = true;
	        System.out.println("ThreadPool SHUTDOWN initiated.");
	    }
	
}
