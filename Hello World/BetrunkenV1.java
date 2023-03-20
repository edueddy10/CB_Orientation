import java.util.Scanner;

public class BetrunkenV1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Wie viel Bier hast du getrunken?");

        int beer = sc.nextInt();

        System.out.println("Wie viel Shots hast du getrunken?");

        int shots = sc.nextInt();


        if ((beer == 0) && (shots == 0)) {          //2 ist gleich Zeichen! für einen Vergleich
            System.out.println("Gar nicht betrunken");
        }
        else if ((beer <=2) && (shots <=2)) {
            System.out.println("leicht betrunken");
        }
        else if ((beer <=6) && (shots ==0)) {
            System.out.println("Betrunken");
        }
        else {
            System.out.println("Hoffnungslos betrunken");
        }

    }
}

