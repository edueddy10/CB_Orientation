import java.util.Scanner;
public class MultiplikationsAlgorithmus {
    public static void main(String[] args) {

        int a;
        int b;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a + " x " + b + "\n");

        do {

            if (a % 2 != 0) {
                System.out.println(a + " x " + b);
                sum += b;
            } else if (a % 2 == 0) {
                System.out.println(a + " x " + b + " durchgestrichen"); // b muss durchgestrichen sein
            }

            a = a/2;
            b = b * 2;

        }while (a >= 1);
        System.out.println("   ===");
        System.out.println("   " + sum);

    }
}
