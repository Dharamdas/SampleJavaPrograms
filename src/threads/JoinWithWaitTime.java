package threads;

public class JoinWithWaitTime {

	public static void main(String[] args) throws InterruptedException {

	     System.out.println("In main() method");
         MyRunnable1 runnable=new MyRunnable1();
         Thread thread1=new Thread(runnable);
         Thread thread2=new Thread(runnable);
         thread1.start();
         thread1.join(1000);  //once 1000 millisec are up, main thread can resume and start thread2.
         thread2.start();
         thread2.join();
         System.out.println("end main() method");
		
	}

}

class MyRunnable1 implements Runnable{
    public void run(){
           System.out.println("in run() method");
           for(int i=0;i<5;i++){
                  try {
                        Thread.sleep(5000);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
                  System.out.println("i="+i+" ,ThreadName="+Thread.currentThread().getName());
           }          
    }
}