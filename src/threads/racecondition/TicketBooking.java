package threads.racecondition;

public class TicketBooking implements Runnable{

	int ticketsAvailable=1;
    
    public void run(){
           
           System.out.println("Waiting to book ticket for : "+Thread.currentThread().getName());
         synchronized (this) {
           if(ticketsAvailable>0){
                  System.out.println("Booking ticket for : "+Thread.currentThread().getName());
                  
                  //Let's say system takes some time in booking ticket (here we have taken 1 second time)
                  try{
                        Thread.sleep(1000); 
                  }catch(Exception e){}
                    
                  ticketsAvailable--;
                  System.out.println("Ticket BOOKED for : "+ Thread.currentThread().getName());
                  System.out.println("currently ticketsAvailable = "+ticketsAvailable);
           }
           else{
                  System.out.println("Ticket NOT BOOKED for : "+ Thread.currentThread().getName());
           }
         } //end Synch Block
           
           
    }
}
