package collections.compairableandcompairatorboth;

import java.util.Comparator;

public class Employee {
	private int empId;
	private String name;
	private double salary;
	
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	Employee(int empId,String name,double salary)
	{
		this.empId=empId;
		this.name=name;
		this.salary=salary;
	}
	
	public Comparable<Employee> compairablebyEmpId = new Comparable<Employee>() {
		
		@Override
		public int compareTo(Employee o) {
			return Employee.this.getEmpId()-o.getEmpId();
		}
	};
	
	public Comparator<Employee> comparatorByEmpSalary = new Comparator<Employee>() {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			return (int) (emp1.getSalary()-emp2.getSalary());
		}
	};
	
}
