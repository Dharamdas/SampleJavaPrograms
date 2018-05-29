package collections.compairatorimpl;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{

	private int id;
    private String name;
    private int age;
    private long salary;
   
    
    public int getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public int getAge() {
        return age;
    }
 
    public long getSalary() {
        return salary;
    }
 
    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public Employee() {
    }

    public int compare(Employee e1, Employee e2) {
        return  (int) (e1.getId() - e2.getId());
    }
    public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
    	 
        @Override
        public int compare(Employee e1, Employee e2) {
        	return (int) (e1.getSalary() - e2.getSalary());
        }
    };
 
   
}
