import java.util.Scanner;
public class TaschenrechnerV3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char operator = 'A';

        //user input:
        while (operator != 'X') {

            System.out.println("Gib den Operator (+, -, *, /, %) ein, oder breche mit X ab");

            operator = sc.nextLine().charAt(0);

            if ((operator == '+') || (operator == '-') || (operator == '/') || (operator == '*') || (operator == '%')) {


                System.out.println("Gib die erste Zahl ein:");

                int a = sc.nextInt();

                System.out.println("Gib die zweite Zahl ein:");

                int b = sc.nextInt();



                    //calculations and output:
                    switch (operator) {
                                case '+':
                                    System.out.println("+");
                                    System.out.println(a + " " + operator + " " + b + " = " + (a + b));
                                    break;
                                case '-':
                                    System.out.println("-");
                                    System.out.println(a + " " + operator + " " + b + " = " + (a - b));
                                    break;
                                case '*':
                                    System.out.println("*");
                                    System.out.println(a + " " + operator + " " + b + " = " + (a * b));
                                    break;
                                case '/':
                                    System.out.println("/");
                                    System.out.println(a + " " + operator + " " + b + " = " + (a / b));
                                    break;
                                case '%':
                                    System.out.println("%");
                                    System.out.println(a + " " + operator + " " + b + " = " + (a % b));
                                    break;
                                default:
                                    System.out.println("Falscher Operator");


                            }
                            sc.nextLine();
                }
            }
        }
    }



