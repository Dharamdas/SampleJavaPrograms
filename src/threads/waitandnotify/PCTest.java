package threads.waitandnotify;

import java.util.Vector;

public class PCTest {

	public static void main(String[] args) {

		Vector v = new Vector();
		int size=5;
		Producer producer = new Producer(v, size);
		Consumer consumer = new Consumer(v, size);
		producer.setName("Producer");
		consumer.setName("Consumer");
		producer.start();
		consumer.start();
		System.out.println("PC problem done::::");
		
	}

}
