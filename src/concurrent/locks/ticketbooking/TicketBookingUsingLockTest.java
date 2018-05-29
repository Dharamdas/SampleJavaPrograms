package concurrent.locks.ticketbooking;

import java.util.concurrent.locks.ReentrantLock;

public class TicketBookingUsingLockTest {

	public static void main(String[] args) {

		ReentrantLock lock=new ReentrantLock();
		TicketBookingUsingLock myRunnable=new TicketBookingUsingLock(lock);
        new Thread(myRunnable,"Passenger-1 Thread").start();
        new Thread(myRunnable,"Passenger-2 Thread").start();
        new Thread(myRunnable,"Passenger-3 Thread").start();
        new Thread(myRunnable,"Passenger-4 Thread").start();
	}

}
