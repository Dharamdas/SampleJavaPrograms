package concurrent.threadpool.mythreadpool;

public class MyThreadPoolTest {

	public static void main(String[] args) {

		CustomtThreadPool pool = new CustomtThreadPool(3);
		try {
			for(int i=1;i<4;i++)
			{	pool.execute(new MyTask());
			    if(i==1)
				pool.execute(new MyTask1());
			} 
			pool.shutDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
