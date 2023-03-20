import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class ZahlenRatenV1Level3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        ArrayList<Integer> pickedNumbersLv3 = new ArrayList<>();
        boolean userStartsFirst = true;
        int pickNumberLv3;

        int min = 0;
        int max = 100;


        System.out.println("Eine Random Nummber zwischen 0 - 100 wird generiert");
        int randomNumberLv3 = r.nextInt(101);
        userStartsFirst = r.nextBoolean();

        if (userStartsFirst) {

            do {
            //Benutzer ein und Ausgaben //

                System.out.println("\nErrate die Nummer zwischen 0 - 100");
                pickNumberLv3 = sc.nextInt();

                pickedNumbersLv3.add(pickNumberLv3);

                if (pickNumberLv3 != randomNumberLv3) {
                    System.out.println("Falsch geraten, probiere weiter");
                }

                if (pickNumberLv3 < randomNumberLv3) {
                    System.out.println("Die Nummer nach der gesucht wird ist größer als deine Eingabe: " + pickNumberLv3);
                    min = pickNumberLv3;
                } else if (pickNumberLv3 > randomNumberLv3) {
                    System.out.println("Die Nummer nach der gesucht wird ist kleiner als deine Eingabe: " + pickNumberLv3);
                    max = pickNumberLv3;
                }

                if (pickNumberLv3 != randomNumberLv3) {
                //Ende Benutzer ein und Ausgaben//
                //Anfang Computer Ein und Ausgaben//

                System.out.println("\nDer Computer versucht die Nummer zu erraten");
                pickNumberLv3 = (max + min) / 2;
                pickedNumbersLv3.add(pickNumberLv3);
                System.out.println("Computer denkt die Zahl ist: " + pickNumberLv3);

                if (pickNumberLv3 < randomNumberLv3) {
                    min = pickNumberLv3 + 1;
                    System.out.println("Sorry Computer, Die Nummer nach der gesucht wird ist größer als deine Eingabe: " + pickNumberLv3);
                }
                if (pickNumberLv3 > randomNumberLv3) {
                    max = pickNumberLv3 - 1;
                    System.out.println("Sorry Computer, Die Nummer nach der gesucht wird ist kleiner als deine Eingabe: " + pickNumberLv3);
                }

                //Ende Computer Ein und Ausgaben//

                System.out.println("\nFolgende Tips wurden bereits abgegeben:\n" + pickedNumbersLv3);
                }
            } while (pickNumberLv3 != randomNumberLv3);
            System.out.println("\nDie Zahl wurde Erraten");

        } else if (!userStartsFirst) {
            System.out.println("\nDer Computer versucht die Nummer zu erraten");
            pickNumberLv3 = r.nextInt(101);
            pickedNumbersLv3.add(pickNumberLv3);
            System.out.println("Computer denkt die Zahl ist: " + pickNumberLv3);
            if (pickNumberLv3 != randomNumberLv3) {
                if (pickNumberLv3 < randomNumberLv3) {
                    min = pickNumberLv3 + 1;
                    System.out.println("Sorry Computer, Die Nummer nach der gesucht wird ist größer als deine Eingabe: " + pickNumberLv3);
                }
                if (pickNumberLv3 > randomNumberLv3) {
                    max = pickNumberLv3 - 1;
                    System.out.println("Sorry Computer, Die Nummer nach der gesucht wird ist kleiner als deine Eingabe: " + pickNumberLv3);
                }

                do {
                    //Benutzer ein und Ausgaben //

                    System.out.println("\nErrate die Nummer zwischen 0 - 100");
                    pickNumberLv3 = sc.nextInt();

                    pickedNumbersLv3.add(pickNumberLv3);

                    if (pickNumberLv3 != randomNumberLv3) {
                        System.out.println("Falsch geraten, probiere weiter");
                    }

                    if (pickNumberLv3 < randomNumberLv3) {
                        System.out.println("Die Nummer nach der gesucht wird ist größer als deine Eingabe: " + pickNumberLv3);
                        min = pickNumberLv3;
                    } else if (pickNumberLv3 > randomNumberLv3) {
                        System.out.println("Die Nummer nach der gesucht wird ist kleiner als deine Eingabe: " + pickNumberLv3);
                        max = pickNumberLv3;
                    }

                    if (pickNumberLv3 != randomNumberLv3) {
                        //Ende Benutzer ein und Ausgaben//
                        //Anfang Computer Ein und Ausgaben//

                        System.out.println("\nDer Computer versucht die Nummer zu erraten");
                        pickNumberLv3 = (max + min) / 2;
                        pickedNumbersLv3.add(pickNumberLv3);
                        System.out.println("Computer denkt die Zahl ist: " + pickNumberLv3);

                        if (pickNumberLv3 < randomNumberLv3) {
                            min = pickNumberLv3 + 1;
                            System.out.println("Sorry Computer, Die Nummer nach der gesucht wird ist größer als deine Eingabe: " + pickNumberLv3);
                        }
                        if (pickNumberLv3 > randomNumberLv3) {
                            max = pickNumberLv3 - 1;
                            System.out.println("Sorry Computer, Die Nummer nach der gesucht wird ist kleiner als deine Eingabe: " + pickNumberLv3);
                        }

                        //Ende Computer Ein und Ausgaben//

                        System.out.println("\nFolgende Tips wurden bereits abgegeben:\n" + pickedNumbersLv3);
                    }
                } while (pickNumberLv3 != randomNumberLv3);
            }
            System.out.println("\nDie Zahl wurde Erraten");
        }









    }

}
