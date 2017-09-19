public class Main {

    public static void main(String[] args) {
        String s = TextIn.getText();
        String[] ms = TextConverter.converter(s);
        TextOut.textOut(ms);
    }
}
