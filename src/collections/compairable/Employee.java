package collections.compairable;

public class Employee implements Comparable<Employee> {
	private int empId;
	private String name;
	
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
	Employee(int empId,String name)
	{
		this.empId=empId;
		this.name=name;
	}
	@Override
	public int compareTo(Employee o) {
		return this.getEmpId()-o.getEmpId();
	}
}
