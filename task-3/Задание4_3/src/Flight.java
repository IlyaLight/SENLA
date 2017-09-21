/**
 * Created by Light on 20.09.2017.
 */
public class Flight {
    public static final int IN_TIME =  0;
    public static final int CANCELED = 1;
    public static final int DELAYED =  2;
    public static final String [] STATUS = new String[]{ "IN_TIME", "CANCELED", "DELAYED"};

    private String name;
    private int place = 100;
    private Passenger[] passengers = new Passenger[0];
    private int status = 0;

    public Flight(String name) {
        this.name = name;
    }

    public String toString(){
        return name + "\tststus - " + STATUS[status] + "\tfree places - " + (place - passengers.length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
