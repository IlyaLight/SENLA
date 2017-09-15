package task;
public class Employee extends Person  {
	protected  IdCard idCard;
	Employee(){System.out.println("my name is \"Employee\"");
	}
	public void setIdCard(IdCard idCard){
		this.idCard = idCard;
	}

}