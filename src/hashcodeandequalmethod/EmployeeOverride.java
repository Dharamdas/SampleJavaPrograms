package hashcodeandequalmethod;

import java.util.HashMap;

public class EmployeeOverride {

    public static void main(String...a){

        HashMap<Employee, String> hm=new HashMap<Employee, String>();
        hm.put(new Employee(1,"sam"), "employee1 data");
        hm.put(new Employee(2,"amy"), "employee2 data");

        System.out.println("HashMap's data> "+hm);
        System.out.println(hm.get(new Employee(1,"sam")));

        hm.put(new Employee(1,"sam"), "employee1 data OVERRIDDEN");
        System.out.println("\nAgain display HashMap after overriding data "+
                "of Employee with id=1 and name=’sam’\n");

        System.out.println("HashMap's data> "+hm);
        System.out.println(hm.get(new Employee(1,"sam")));

    }
}
