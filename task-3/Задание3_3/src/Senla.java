/**
 * Created by Light on 20.09.2017.
 */
public class Senla {

    private Employee[] employees;
    private Bookkeeping bookkeeping = new Bookkeeping();

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    int getSalaryCost(){
        return bookkeeping.getSalaryCost(employees);
    }

}
