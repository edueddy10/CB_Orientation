import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV3 {
    public static void main(String[] args) {

        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int head = 0;
        int tails = 0;
        int numberofthrows = 0;

        do {
            System.out.println("Wie oft soll die Münze geworfen werden?");
            numberofthrows = sc.nextInt();
        } while ((numberofthrows < 1) ||
                (numberofthrows >= 10) ||
                (numberofthrows % 2 == 0)); // solange gerade


        for (int a = 1; a <= numberofthrows; a++) {

            boolean cointhrow = r.nextBoolean();

            if (cointhrow) {
                System.out.println("Werfe Münze..." + "Kopf!");
                head++;
            } else {
                System.out.println("Werfe Münze..." + "Zahl!");
                tails++;
            }
        }


        System.out.println("Summe Kopf: " + head);  //Kopf ist der User
        System.out.println("Summe Zahl: " + tails); //Zahl ist der Stefan

        if (head > tails) {
            System.out.println("Ich bekomme das Ticket.");
        } else if (head < tails) {
            System.out.println("Stefan bekommt das Ticket.");
//        } else if (head == tails) {
//            System.out.println("Unentschieden! Keiner bekommt das Ticket.");  //nicht mehr notwendig, da mit der do while Schleife nur mehr ungerade Zahlen möglich sind...Unentschieden daher unmöglich.
       }

    }
}
