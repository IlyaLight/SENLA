public class Main {

    public static void main(String[] args) {

        Senla senla = new Senla();
        senla.setEmployees( new Employee[]{
                new Boss(1000),new Lawyer(800), new Lawyer(600), new Programmer(400)});
        System.out.println(senla.getSalaryCost());
    }
}
