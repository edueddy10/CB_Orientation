import java.util.Random;
import java.util.Scanner;

public class BetrunkenV2_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Wie alt bist du?");
        int age = sc.nextInt();

        System.out.println("Hast du deinen Führerschein dabei?");

        boolean license = false;
        if (age >= 17) {
            Random r = new Random();
            license = r.nextBoolean();
            System.out.println(license);
        } else System.out.println(license);

        if (!license) {
            System.out.println("Du darfst nicht Auto fahren");
        }
        else {
            System.out.println("Wie viel Bier hast du getrunken?");
            int beer = sc.nextInt();

            System.out.println("Wie viel Shots hast du getrunken?");
            int shots = sc.nextInt();

            if ((age < 19 && (beer + shots > 0))
                    || (age >=19 && (beer + shots > 2))) {
                System.out.println("Du darfst nicht Auto fahren");
            } else {
                System.out.println("Du darfst Auto fahren");
            }

            /*if ((age < 19) && ((beer > 0) || (shots > 0))) {
                System.out.println("Du darfst nicht Auto fahren");
            } else if ((age >= 19) && ((beer + shots <= 2))) {
                System.out.println("Du darfst Auto fahren");
            } else if ((age >=19) && (beer + shots > 2)){
                System.out.println("Du darfst nicht Auto fahren");
            }
            else {
                System.out.println("Du darfst Auto fahren.");
            }*/
        }

        }
    }

