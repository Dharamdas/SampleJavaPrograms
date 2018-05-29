package collections.hashcodeandequal;

public class Employee {
	private Integer empid;
	private String name;
	private String loc;
	private String branch;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public boolean equals(Object obj)
	{
		try{
		
		if(obj==null)
			return false;
		if(!(obj instanceof Employee))
			return false;
		Employee emp = (Employee)obj;
		if(this.empid!=emp.empid && !this.name.equals(emp.name))
			return false;
		
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public int hashCode()
	{
		System.out.println("HashCode Method Called "+this.getEmpid());
		int hash=(this.empid==null ? 0: this.empid.hashCode() ) +
                (this.name==null ? 0: this.name.hashCode() );
		return hash;     
	}
}
