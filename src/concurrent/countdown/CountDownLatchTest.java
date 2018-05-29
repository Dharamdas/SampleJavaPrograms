package concurrent.countdown;

import java.util.concurrent.CountDownLatch;
/*
 * Application of CountDownLatch in real world >
When you go in amusement park, you must have seen on certain rides there is mandate 
that at least 3 people (3 is count) should be there to take a ride. So, ride keeper 
(ride keeper is main thread) waits for 3 persons (ride keeper has called await()).
Every time a person comes count is reduced by 1 (let’s say every person is calling 
countDown() method). Ultimately when 3 persons reach count becomes 0 & wait for ride 
keeper comes to end.
 * */

public class CountDownLatchTest {

	public static void main(String[] args) {
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		//"CountDownLatch has been created with count=3"
		
		MyRunnable myRunnable = new MyRunnable(countDownLatch);
		Thread t = new Thread(myRunnable);
		t.start();
		
		try{
			countDownLatch.await();
			AfterLetchRelease letchRelease = new AfterLetchRelease();
			Thread t2 = new Thread(letchRelease);
			t2.start();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		 System.out.println("count has reached zero, "+
                 Thread.currentThread().getName()+" thread has ended");
	}

}
