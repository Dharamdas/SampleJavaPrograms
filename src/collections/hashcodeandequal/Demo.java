package collections.hashcodeandequal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {

		HashMap map = new HashMap();
		Employee e1 = new Employee();
		e1.setEmpid(101);
		e1.setName("Raj");
		e1.setBranch("Bang");
		e1.setLoc("Bang");
		
		Employee e2 = new Employee();
		e2.setEmpid(102);
		e2.setName("Raju");
		e2.setBranch("hyd");
		e2.setLoc("hyd");
		map.put(e1, "First Object");
		map.put(e2, "Second Object");
		
		Employee e3 = new Employee();
		e3.setEmpid(101);
		e3.setName("Raj");
		System.out.println(" Map Value using get method "+map.get(e3));
		
		// iterating the MAP object
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext())
		{
			Entry e = (Entry)it.next();
			System.out.println(((Employee)e.getKey()).getEmpid());
			System.out.println(e.getValue());
		}
		
	}

}
