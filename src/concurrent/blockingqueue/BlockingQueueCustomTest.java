package concurrent.blockingqueue;

public class BlockingQueueCustomTest {

	public static void main(String[] args) throws InterruptedException{

		LinkedBlockingQueueCustom<Integer> b=new LinkedBlockingQueueCustom<Integer>(10);
	        System.out.println("put(11)");
	        b.put(11);
	        System.out.println("put(12)");
	        b.put(12);
	        System.out.println("take() > "+b.take());
	        System.out.println("take() > "+b.take());
	}

}
