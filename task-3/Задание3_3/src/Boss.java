/**
 * Created by Light on 20.09.2017.
 */
public class Boss implements Employee {

    public Boss(int salary) {
        this.salary = salary;
    }

    private int salary;

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
