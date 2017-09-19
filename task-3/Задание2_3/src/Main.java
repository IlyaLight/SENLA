public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] i = GetNumber.getNuber();
        long  sequential = SeqRecord.seqRecord(i[0],i[1]);
        PrinNumber.printNuber(i);
        PrinNumber.printNuber(sequential-i[2]);
    }

}
