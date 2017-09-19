import java.util.Random;

public class GetNumber {
    static int[] getNuber(){
        int[] i = new int[3];
        Random random = new Random();
        for (int j = 0; j < 3; j++) {
            i[j] = random.nextInt();
        }
        return i;
    }
}
