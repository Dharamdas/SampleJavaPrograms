package hashcodeandequalmethod;

import jdk.nashorn.internal.objects.annotations.Setter;


public class Employee {

    private Integer id;
    private String name;
    Employee(Integer id,String name){this.id=id;this.name=name;}

    public boolean equal(Object object){

        if(object==null)
            return false;
        if(object.getClass()!=this.getClass())
            return false;

        Employee emp = (Employee)object;
        return (this.id==emp.id || emp.id.equals(this.id) && this.name==emp.name || emp.name.equals(this.name));

    }

    public int hashCode(){
        return (this.id==0?0:this.id.hashCode() +this.name==null?0:this.name.hashCode());
    }

}
