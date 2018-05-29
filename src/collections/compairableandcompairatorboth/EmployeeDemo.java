package collections.compairableandcompairatorboth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class EmployeeDemo {

	public static void main(String[] args) {


		Employee emp5 = new Employee(104,"Raj",5000);
		Employee emp1=new Employee(102,"Raju",100);
		Employee emp2 = new Employee(109,"Suhil",4000);
		Employee emp3 = new Employee(101,"Manish M",200000);
		Employee emp4 = new Employee(103,"Manish M",900);
		System.out.println("Before Sorting: ");
		// array Sorting
		Employee emp[] = new Employee[5];
		emp[0] = emp1;
		emp[1]=  emp2;
		emp[2] = emp3;
		emp[3] = emp4;
		emp[4] = emp5;
		System.out.println("Before Sorting: ");
		for(Employee e:emp)
			System.out.println("Emp Id: "+e.getEmpId()+" Salary : "+e.getSalary()+"  Emp Name: "+e.getName());
		Arrays.sort(emp,new Employee().comparatorByEmpSalary);
		System.out.println("After Sorting::::");
		//for(Employee e:emp)
			//System.out.println("Emp Id: "+e.getEmpId()+" Salary : "+e.getSalary()+"  Emp Name: "+e.getName());		
	
		// Array List Sorting
	    List<Employee> emplist = new ArrayList<Employee>();
	    emplist.add(emp1);
	    emplist.add(emp2);
	    emplist.add(emp3);
	    emplist.add(emp4);
	    emplist.add(emp5);
	    //Collections.sort(emplist,new Employee().compairablebyEmpId);
	    Collections.sort(emplist,new Employee().comparatorByEmpSalary);
	    //for(Employee e:emplist)
			//System.out.println("Emp Id: "+e.getEmpId()+" Salary : "+e.getSalary()+"  Emp Name: "+e.getName());	
	    
	    // Set to implement comprator
	    //Set setEmp = new HashSet(new Employee().comparatorByEmpSalary); // not possible 
	    // TreeSet
	    
	    Set<Employee> setEmp = new TreeSet<Employee>(new Employee().comparatorByEmpSalary);
	    setEmp.add(emp1);
	    setEmp.add(emp2);
	    setEmp.add(emp3);
	    setEmp.add(emp4);
	    setEmp.add(emp5);
	    for(Employee e: setEmp)
	    {
	       	System.out.println("Emp Id: "+e.getEmpId()+" Salary : "+e.getSalary()+"  Emp Name: "+e.getName());
	    }
	/*    Iterator set = setEmp.iterator();
	    while(set.hasNext())
	    {
	    	Employee e =(Employee)set.next();
	    	System.out.println("Emp Id: "+e.getEmpId()+" Salary : "+e.getSalary()+"  Emp Name: "+e.getName());
	    }*/
	    
	    //Map<Employee,String> m = new HashMap<Employee,String>(new Employee().comparatorByEmpSalary); //not possible
	    TreeMap<Employee,String> tm = new TreeMap<Employee,String>(new Employee().comparatorByEmpSalary);
	    //Hashtable<Employee, String> ht = new Hashtable<Employee, String>(new Employee().comparatorByEmpSalary);
	    Map<Employee,String> treemap = new TreeMap<Employee,String>(new Employee().comparatorByEmpSalary);
	   // SortedSet set = new SortedSet(new Employee().compairablebyEmpId);
	}

}
