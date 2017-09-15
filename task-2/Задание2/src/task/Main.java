package task;
public class Main{
	public static void main(String[] args) {
		System.out.println("task2");
		Employee employee = new Employee();
		IdCard idCard = new IdCard();
		employee.setIdCard(idCard);
		WorkinGroup workinGroup = new WorkinGroup();
		Employee[] employees = new Employee[]{employee};
		workinGroup.setWorkinGroup(employees);
	}
}