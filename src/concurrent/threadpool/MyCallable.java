package concurrent.threadpool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long>{

	@Override
	public Long call() throws Exception {
		System.out.println("Called Call() ");
		return (long) 10;
	}

}
