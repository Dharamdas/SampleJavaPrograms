package threads;

public class CreatingProcess {

	public static void main(String[] args) {

		//Executing Process
		Thread thread1=new Thread(new Process1(),"Thread-1");
        Thread thread2=new Thread(new Process2(),"Thread-2");
        thread1.start();
        thread2.start();
		
	}

}

class Process1 implements Runnable{
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

class Process2 implements Runnable{
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
