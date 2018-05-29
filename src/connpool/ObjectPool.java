package connpool;

import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ObjectPool {

	   
	   private Hashtable<Object,Long> locked, unlocked;        
	   private long expirationTime;
	   abstract Object create();
	   abstract boolean validate( Object o );
	   abstract void expire( Object o );
	   
	   public ObjectPool() {
		   expirationTime = 30000; //30 second
		   locked = new Hashtable<Object,Long>();
		   unlocked = new Hashtable<Object,Long>();
		   }
	   
	   synchronized Object checkOut(){   // take the connection object
		
		   long now = System.currentTimeMillis();
		   Object o;
		   
		   if(unlocked.size()>0)
		   {
			   Enumeration en = unlocked.keys();
			   while(en.hasMoreElements())
			   {
				   o = en.nextElement();
				   if(now- (((Long) unlocked.get(o)).longValue())>expirationTime)
				   {
					   // object has expired
					   unlocked.remove(o);
					   o=null;
				   }else{
					   if(validate(o))
					   {
						   unlocked.remove(o);   
						   locked.put(o, new Long(now));
						   return o;
					   }else
					   {
						   // object failed validation
						   unlocked.remove(o);
						   o=null;
					   }
				   }
				   
				   
			   }
		   }
		   
		   // no object is available create new object
		   o = create();
		   locked.put(o, now);
		   return o;
	   }
	   synchronized void checkIn( Object o ){   //for freeing the connection object
		    locked.remove(o);
		    unlocked.put(o, new Long(System.currentTimeMillis()));
	   }
}
