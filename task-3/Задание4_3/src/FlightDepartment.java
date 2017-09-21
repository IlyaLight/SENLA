/**
 * Created by Light on 20.09.2017.
 */
public class FlightDepartment {
    Flight[] flights;

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    public void showInfoOfFlights(){
        InformationTable.Show(flights);
    }
}
