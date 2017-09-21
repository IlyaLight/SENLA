public class Main {

    public static void main(String[] args) {
	    Flight flight0 = new Flight("Hrodno - Piter");
	    Passenger[] passengers = new Passenger[40];
        for (int i = 0; i < 40; i++) {
            passengers[i] = new Passenger();
        }
        flight0.setPassengers(passengers);

        Flight flight1 = new Flight("Hrodno - Moskva");
        passengers = new Passenger[20];
        for (int i = 0; i < 20; i++) {
            passengers[i] = new Passenger();
        }
        flight1.setPassengers(passengers);

        Flight flight2 = new Flight("Hrodno - Stambul");
        passengers = new Passenger[50];
        for (int i = 0; i < 50; i++) {
            passengers[i] = new Passenger();
        }
        flight2.setPassengers(passengers);
        flight2.setStatus(Flight.CANCELED);

        FlightDepartment flightDepartment = new FlightDepartment();
        flightDepartment.setFlights( new Flight[]{flight0,flight1,flight2});
        flightDepartment.showInfoOfFlights();


    }
}
