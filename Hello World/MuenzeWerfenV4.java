import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV4 {
    public static void main(String[] args) {

        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int head = 0;
        int tails = 0;
        int numberofthrows = 0;
        boolean areyouhappy = false;
        int headsum;
        int tailssum;
        int numberofthrowssum = 0;

        while (!areyouhappy) {


            do {
                System.out.println("Wie oft soll die Münze geworfen werden (INSGESAMT ungerade Zahl 1-10)?");
                numberofthrows = sc.nextInt();
            } while ((numberofthrows < 1) ||
                    (numberofthrows >= 10) ||
                    ((numberofthrowssum + numberofthrows) % 2 == 0));


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

            System.out.println("Bist du mit dem Ergebnis zufrieden?");
            areyouhappy = sc.nextBoolean();

            if (areyouhappy) {
                System.out.println("Stefan bekommt das Ticket.");
            }

            headsum = head;
            tailssum = tails;
            numberofthrowssum = headsum + tailssum;


        }
    }
}


//        if (head > tails) {
//            System.out.println("Ich bekomme das Ticket.");
//        } else if (head < tails) {
//            System.out.println("Stefan bekommt das Ticket.");
//        }


