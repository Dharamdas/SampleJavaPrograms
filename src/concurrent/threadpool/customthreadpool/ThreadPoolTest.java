package concurrent.threadpool.customthreadpool;

public class ThreadPoolTest {

	public static void main(String[] args) throws Exception {

		CustomThreadPool threadPool=new CustomThreadPool(2); //create 2 threads in ThreadPool 
         Runnable task=new Task();
         threadPool.execute(task);
         threadPool.execute(task);
         
         threadPool.shutdown();
	}

}
