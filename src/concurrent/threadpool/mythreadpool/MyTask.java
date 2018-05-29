package concurrent.threadpool.mythreadpool;

public class MyTask implements Runnable{

	@Override
	public void run() {

		for(int i=0;i<5;i++)
			System.out.println("From MyTask::"+i);
	}

}
