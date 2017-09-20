/**
 * Created by Light on 20.09.2017.
 */
public class Bookkeeping {
    public int getSalaryCost(Employee[] employees){
        int cost = 0;
        for (Employee employee : employees) {
            cost += employee.getSalary();
        }
        return cost;
    }
}
