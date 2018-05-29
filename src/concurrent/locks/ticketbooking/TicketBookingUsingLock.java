package concurrent.locks.ticketbooking;

import java.util.concurrent.locks.ReentrantLock;

public class TicketBookingUsingLock implements Runnable{

	int ticketsAvailable=2;
    ReentrantLock lock;
    
    public TicketBookingUsingLock(ReentrantLock lock) { 
           this.lock=lock;
    }
    
    public void run(){
           
           System.out.println("Waiting to book ticket for : "+
                               Thread.currentThread().getName());
           lock.lock();
           if(ticketsAvailable>0){
                  System.out.println("Booking ticket for : "+
                                      Thread.currentThread().getName());

                  //Let's say system takes some time in booking ticket
                  //(here we have taken 1 second time)
                  try{
                        Thread.sleep(1000); 
                  }catch(Exception e){}
                    
                  ticketsAvailable--;
                  System.out.println("Ticket BOOKED for : "+Thread.currentThread().getName());
                  System.out.println("Number of Customer Waiting for this Ticket: "+lock.getQueueLength());
                  System.out.println("currently ticketsAvailable = "+ticketsAvailable);
           }
           else{
                  System.out.println("Ticket NOT BOOKED for : "+
                                      Thread.currentThread().getName());
           }
           
           
           lock.unlock();    //read explanation for 5sec
    }
}
