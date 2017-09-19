public class SeqRecord {
    static long seqRecord (int a, int b){
        String s = Integer.toString(a)+ Integer.toString(Math.abs(b));
        return Long.valueOf(s);
    }
}
