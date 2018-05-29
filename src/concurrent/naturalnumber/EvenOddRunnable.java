package concurrent.naturalnumber;

public class EvenOddRunnable implements Runnable{

	 int count = 1;
	 String currentThreadName = "Odd";
	 Object lock = new Object();
	 
	@Override
	public void run() {

		while(count<=10)
		{
			synchronized(lock)
			{
				try{
					if(currentThreadName.equals(Thread.currentThread().getName()))
					{
						System.out.println(Thread.currentThread().getName()+" "+count++);
						if(currentThreadName.equals("Odd"))
						{
							currentThreadName="Even";
						}
						else
							{
							currentThreadName="Odd";
							}
						
						lock.notifyAll();
						
					}else
					{
						lock.wait();
					}
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}

}
