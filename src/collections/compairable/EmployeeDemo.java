package collections.compairable;

import java.util.Arrays;

public class EmployeeDemo {

	public static void main(String[] args) {

		Employee emp[] = new Employee[5];
		emp[0] = new Employee(104,"Raj");
		emp[1]=new Employee(102,"Raju");
		emp[2] = new Employee(109,"Suhil");
		emp[3] = new Employee(101,"Manish M");
		emp[4] = new Employee(103,"Manish M");
		
		System.out.println("Before Sorting: ");
		for(Employee e:emp)
			System.out.println("Emp Id: "+e.getEmpId()+"  Emp Name: "+e.getName());
		
		Arrays.sort(emp);
		System.out.println("After Sorting::::");
		for(Employee e:emp)
			System.out.println("Emp Id: "+e.getEmpId()+"  Emp Name: "+e.getName());
		
	}

}
