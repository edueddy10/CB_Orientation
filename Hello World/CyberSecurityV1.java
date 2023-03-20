import java.util.Random;
public class CyberSecurityV1 {
    public static void main(String[] args) {

        Random r = new Random();
        String[] chars = {"A", "B", "C", "a", "b", "c", "0", "1", "2", "!"};

            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {
                    for (int c = 0; c < 10; c++) {
                        for (int d = 0; d < 10; d++) {
                            System.out.print(chars[a]);
                            System.out.print(chars[b]);
                            System.out.print(chars[c]);
                            System.out.print(chars[d]);
                            System.out.println();


                            }
                        }
                    }
                }


    }
}
