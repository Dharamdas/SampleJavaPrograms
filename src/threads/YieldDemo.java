package threads;

class AllocateDesk extends Thread{
	
	public void run()
	{
		System.out.println("Please allocate the Desk To employee");
		Thread.yield();
		System.out.println("allocated Desk to Employee");
	}
}
class DoJoiningFormalities extends Thread
{
	public void run()
	{
		System.out.println("Please do joining formalites befor allocting the Desk to employee");
	}
}
public class YieldDemo {

	
	public static void main(String[] args) {
		
		System.out.println("Company Normas");
		AllocateDesk allocateDesk = new AllocateDesk();
		DoJoiningFormalities formalities = new DoJoiningFormalities();
		allocateDesk.start();
		formalities.start();
  
	}

}
