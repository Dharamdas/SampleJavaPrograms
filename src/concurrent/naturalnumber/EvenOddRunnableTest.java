package concurrent.naturalnumber;

public class EvenOddRunnableTest {

	public static void main(String[] args) {

		EvenOddRunnable evenodd = new EvenOddRunnable();
		Thread t1 = new Thread(evenodd,"Even");
		Thread t2 = new Thread(evenodd,"Odd");
		t1.start();
		t2.start();
		
	}

}
