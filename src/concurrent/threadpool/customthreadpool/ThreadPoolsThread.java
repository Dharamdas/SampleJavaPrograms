package concurrent.threadpool.customthreadpool;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolsThread extends Thread{

	 private BlockingQueue<Runnable> taskQueue;
	 private CustomThreadPool threadPool;
	 
	 public ThreadPoolsThread(BlockingQueue<Runnable> queue,
			 CustomThreadPool threadPool){
		   taskQueue = queue;
		   this.threadPool=threadPool;
  
}
	 
	 public void run() {
         try {
                /*
                 * ThreadPool's threads will keep on running
                 * until ThreadPool is not shutDown (shutDown will interrupt thread) and
                 * taskQueue contains some unExecuted tasks.
                 */
                while (true) {    
                      System.out.println(Thread.currentThread().getName()
                                    +" is READY to execute task.");
                      /*ThreadPool's thread will take() task from sharedQueue
                       * only if tasks are available else
                       * waits for tasks to become available.
                       */
                      Runnable runnable = taskQueue.take();
                      System.out.println(Thread.currentThread().getName()
                                    +" has taken task.");
                      //Now, execute task with current thread.
                      runnable.run();                
                      
                      System.out.println(Thread.currentThread().getName()
                                    +" has EXECUTED task.");
                      
                      /*
                       * 1) Check whether pool shutDown has been initiated or not,
                       * if pool shutDown has been initiated and
                       * 2) taskQueue does not contain any
                       *    unExecuted task (i.e. taskQueue's size is 0 )
                       * than  interrupt() the thread.
                       */
                      if(this.threadPool.isPoolShutDownInitiated()
                                    &&  this.taskQueue.size()==0){
                             this.interrupt();
                         
                             Thread.sleep(1);  
                      }
                      
                }
         } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
         }
  }
}
