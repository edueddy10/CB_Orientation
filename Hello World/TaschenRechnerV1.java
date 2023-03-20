import java.sql.SQLOutput;

public class TaschenRechnerV1 {
    public static void main(String[] args) {

        int a = 8;
        int b = 5;

        System.out.println("Erste Variable: "+a);
        System.out.println("Zweite Variable: "+b);
        System.out.println(a + " + " + b + " = " + (a+b));
        System.out.println(a + " - " + b + " = " + (a-b));
        System.out.println(a + " * " + b + " = " + (a*b));
        System.out.println(a + " / " + b + " = " + ((double) a/b));
        System.out.println(a + " % " + b + " = " + (a%b));
    }
}
