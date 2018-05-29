package collections.compairatorimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeDemo {
	
	public static void main(String[] args) {
        EmpSortObject();
    }
	
	public void JavaObjectSort()
	{
		//sort primitives array like int array
        int[] intArr = {5,9,1,10};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
         
        //sorting String array
        String[] strArr = {"A", "C", "B", "Z", "E"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
         
        //sorting list of objects of Wrapper classes
        List<String> strList = new ArrayList<String>();
        strList.add("A");
        strList.add("C");
        strList.add("B");
        strList.add("Z");
        strList.add("E");
        Collections.sort(strList);
        for(String str: strList) System.out.print(" "+str);
	}
	public static void EmpSortObject()
	{
		//sorting custom object array
		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(10, "Mikey", 253, 10000);
		empArr[1] = new Employee(20, "Arun", 29, 20000);
		empArr[2] = new Employee(5, "Lisa", 35, 5000);
		empArr[3] = new Employee(1, "Pankaj", 32, 50000);
		//sorting employees array using Comparable interface implementation
		Arrays.sort(empArr,new Employee().SalaryComparator);
		System.out.println("Default Sorting of Employees list:\n");
		for(Employee e: empArr)
			System.out.println("Emp Id:  "+e.getId()+" Name : "+e.getName()+ " Salary : "+e.getSalary());
	}
}
