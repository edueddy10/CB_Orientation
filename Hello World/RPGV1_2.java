import java.util.Scanner;
import java.util.ArrayList;
public class RPGV1_2 {
    public static void main(String[] args) {
        // {parentID, ID, choiceTxt, resultTxt, movetoID}
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> viableChoices = new ArrayList<>();
        String [][] choices = {
                {"-1", "0", "", "Du stehst in einer Bar.",},

                {"0", "1", "Geh in die Wildnis", "Du bist in die Wildnis angekommen.",},
                {"0", "2", "Trink ein Getränk", "Du lässt dir ein Getränk schmecken", "0"},
                {"0", "3", "Kämpf gegen den Dieb", "Der Dieb ist ein harter Gegner, aber du besiegst ihn", "0"},

                {"1", "4", "Kämpf gegen das Monster", "Das Monster ist ein harter Gegner, aber du besigst es", "1"},
                {"1", "5", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"},
                {"1", "6", "Lege eine Falle", "Du hast die Falle gelegt. Komm später und schaue nach.", "1"},
        };

        int currentChoice = 0;  //Orientiert sich an die parentID und gibt an in welchem "Raum" des Spieles man ist.

        int checkParentId; // Variable um ParentId in Int umzuwandeln...wird später verwendet, um zu überprüfen: wenn currentChoice mit der checkParentId übereinstimmt, dann zeige NUR die Möglichkeiten an, die einem an diesem Punkt im Enteidungsbaum zustehen.
        int possibleChoices; // Variable um ID in einer ArrayList zu speichern. Wenn currentChoice mit der checkParentID übereinstimmt, dann werden nur diese Werte in die ArrayList gespeichert.

        do {
                viableChoices.clear(); //Array List mit verfügbaren Optionen wird Anfangs gelöscht, um clear zu bleiben

                System.out.println(choices[currentChoice][3]);      //Ausgabe Erste Zeile, in welchem Raum der Spieler steht

                if (choices[currentChoice].length > 4) {
                    currentChoice = Integer.parseInt(choices[currentChoice][4]); //In derIF Statement wird überprüft, ob eine moveto ID vorhanden ist und setzt dann current Choice auf die jeweilige um, falls vorhanden
                    System.out.println("\n" + choices[currentChoice][3]);
                }

                System.out.println("-".repeat(30));         //Ausgabe 2 Zeile (Striche)

                for (int x = 0; x < choices.length; x++) {
                        checkParentId = Integer.parseInt(choices[x][0]);
                    if (checkParentId == currentChoice) {
                        System.out.printf("%s.) ",x);                               //Ausgabe der nächsten Zeilen (Optionen), je nach dem in welchem Raum der Spieler ist
                        System.out.println(choices[x][2]);
                        possibleChoices = Integer.parseInt(choices[x][1]);
                        viableChoices.add(possibleChoices);
                    }
                }

                System.out.println("-".repeat(30));     //Ausgabe Striche

                viableChoices.add(100); //Um eine Option für den Abbruch zu haben
                do {                //Spieler bleibt so lange in Schleife drinnen, bis eine richtige Option ausgewählt wird
                    System.out.println("Was willst du als nächstes tun? (gib 100 ein um abzubrechen)");
                    currentChoice = sc.nextInt();
                } while (!viableChoices.contains(currentChoice));

        }while (currentChoice != 100);

    }
}
