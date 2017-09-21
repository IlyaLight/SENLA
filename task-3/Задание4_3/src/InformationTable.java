/**
 * Created by Light on 21.09.2017.
 */
public class InformationTable {
    public static void Show(Flight[] flights){
        for (Flight flight : flights) {
            System.out.println(flight.toString());
        }
    }
}
