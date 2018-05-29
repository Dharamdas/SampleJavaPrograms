package concurrent.executorservice;

public class ExecutorWithRunnable implements Runnable{

	int taskNumber;
	 
	ExecutorWithRunnable(int taskNumber) {
           this.taskNumber = taskNumber;
    }
 
    @Override
    public void run() {
 
           System.out.println(Thread.currentThread().getName()
                        + " executing task no " + taskNumber);
 
           try {
                  Thread.sleep(1000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
 
    }
	
}
