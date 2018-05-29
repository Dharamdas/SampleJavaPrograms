package concurrent.executorservice;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	private long timeToWait;
	MyCallable(long milliTimeToWait){
		this.timeToWait=milliTimeToWait;
	}
	@Override
	public String call() throws Exception {

		Thread.sleep(timeToWait);
		//throw new Exception();
		return Thread.currentThread().getName();
	}

}
