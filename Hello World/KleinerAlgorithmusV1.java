public class KleinerAlgorithmusV1 {
    public static void main(String[] args) {

        int a = 1;
        int b = 1;
        int c;

        for (int d = 1; d <= 5; d++) {

            c = a + b;

            System.out.println(a + " + " + b + " = " + c);
                a = b;
                b = c;
        }
    }
}
