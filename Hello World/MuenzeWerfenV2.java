import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV2 {
    public static void main(String[] args) {

        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int head = 0;
        int tails = 0;

        System.out.println("Wie oft soll die Münze geworfen werden?");
        int numberofthrows = sc.nextInt();

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
        } else if (head == tails) {
            System.out.println("Unentschieden! Keiner bekommt das Ticket.");
        }

    }
}
