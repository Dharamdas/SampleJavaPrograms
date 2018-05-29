package concurrent.blockingqueue;

import concurrent.blockingqueue.CustomBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class LinkedBlockingQueueCustom<E> implements CustomBlockingQueue<E> {

	private int maxSize;
	private List<E> queue;
	
	LinkedBlockingQueueCustom(int maxSize)
	{
		this.maxSize=maxSize;
		queue= new LinkedList<E>();
	}
	@Override
	public synchronized void put(E item) throws InterruptedException {

		if(this.maxSize==queue.size())
		{
			this.wait();
		}
		
			queue.add(item);
			this.notifyAll();
		
	}

	@Override
	public synchronized  E take() throws InterruptedException {

		if(queue.size()==0)
			this.wait();
		
		this.notifyAll();
		return queue.remove(0);
	}

}
