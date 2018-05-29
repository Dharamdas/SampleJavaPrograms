package threads;

public class CreatingThreadInOneProcess {

	public static void main(String[] args) {

		Process myRunnable=new Process();  // Creating Process 
         Thread thread1=new Thread(myRunnable,"Thread-1"); // Thread -1
         Thread thread2=new Thread(myRunnable,"Thread-2"); // Thread -2
         // Stating 2 Thread on the One Process
         thread1.start(); 
         thread2.start();
		
	}

}

class Process implements Runnable{
    public void run(){
           for(int i=0;i<5;i++){
                  try {
                        Thread.sleep(100);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
                  System.out.println("i="+i+" ,ThreadName="+Thread.currentThread().getName());
           }          
    }
}