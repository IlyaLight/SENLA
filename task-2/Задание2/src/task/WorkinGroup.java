 package task;
 public class WorkinGroup{
 	protected Employee[] employees;
 	WorkinGroup(){
 	System.out.println("my name is \"WorkinGroup\"");
 	}
 	public void setWorkinGroup(Employee[] employees){
 		this.employees = employees.clone();
 	}
 }