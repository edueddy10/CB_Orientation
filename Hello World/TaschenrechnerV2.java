import java.util.Scanner;

public class TaschenrechnerV2 {
    public static void main(String[] args) {

        //user input:
        Scanner sc = new Scanner(System.in);

        System.out.println("Gib die erste Zahl ein:");
        int a = sc.nextInt();

        System.out.println("Gib die zweite Zahl ein:");
        int b = sc.nextInt();

        System.out.println("Gib den Operator (+, -, *, /, %) ein:");
        sc.nextLine();
        char operator = sc.nextLine().charAt(0);


        //calculations and output:
        switch (operator) {
            case '+':
                System.out.println("+");
                System.out.println(a + " " + operator + " "+ b + " = "+(a+b));
                break;
            case '-':
                System.out.println("-");
                System.out.println(a + " " + operator + " " + b + " = "+(a-b));
                break;
            case '*':
                System.out.println("*");
                System.out.println(a + " " + operator + " " + b + " = "+(a*b));
                break;
            case '/':
                System.out.println("/");
                System.out.println(a + " " + operator + " " + b + " = "+(a/b));
                break;
            case '%':
                System.out.println("%");
                System.out.println(a + " " + operator + " " + b + " = "+(a%b));
                break;
            default:
                System.out.println("Falscher Operator");
        }
    }
}

