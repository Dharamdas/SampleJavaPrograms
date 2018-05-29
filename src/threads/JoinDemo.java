package threads;
class InitAppriaslProcess extends Thread
{
	public void run()
	{
		//Thread.yield();
		System.out.println("Initiating Apprisal Process");
	}
}
class RateByEmployee extends Thread
{
	public void run()
	{
		System.out.println("Rate By Employee");
	}
}
class RatedBymanager extends Thread
{
	public void run()
	{
		System.out.println("Manager Has been given traning");
	}
}
class HRFinalizeRating extends Thread
{
	public void run()
	{
		System.out.println("HR finalize the rating");
	}
}
class GotSalaryWithincrement extends Thread
{
	public void run()
	{
		System.out.println("Got Salary With Increment");
	}
}
public class JoinDemo {

	
	public static void main(String[] args) throws Exception {
		System.out.println("Employee Process");
		InitAppriaslProcess initAppriaslProcess = new InitAppriaslProcess();
		RateByEmployee rateByEmployee = new RateByEmployee();
		RatedBymanager bymanager = new RatedBymanager();
		HRFinalizeRating finalizeRating = new HRFinalizeRating();
		GotSalaryWithincrement gotSalaryWithincrement = new GotSalaryWithincrement();

		Thread.yield();

		initAppriaslProcess.start();
		initAppriaslProcess.join();

		rateByEmployee.start();
		bymanager.start();
		bymanager.join();

		finalizeRating.start();
		finalizeRating.join();

		gotSalaryWithincrement.start();
		gotSalaryWithincrement.join();
		//Thread.currentThread().setPriority(10);
	
		System.out.println("End Employee Process");
	}

}
