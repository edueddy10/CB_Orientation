import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class RPGV2 {
    public static void main(String[] args) {
        // {parentID, ID, choiceTxt, resultTxt, movetoID}
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> viableChoices = new ArrayList<>();
        Random r = new Random();
        String[][] choices = {
                {"-1", "0", "", "Du stehst in einer Bar.",},

                {"0", "1", "Geh in die Wildnis auf der Suche nach Abenteuern", "Du bist in der Wildnis angekommen. Du triffst auf ein Monster.",},
                {"0", "2", "Trink ein Getränk und raste dich aus", "Du lässt dir ein Getränk schmecken", "0"},
                {"0", "3", "Beeindrucke die Prinzessin mit deinen Schätzen", "Du gibst alles!", "0"},

                {"1", "4", "Kämpf gegen das Monster", "", "6"},

                {"1", "5", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"},

                {"4", "6", "", ""},

                {"6", "7", "Versuche das Monster mit deinem Schwert zu erwischen", "Du wirfst dich in die Schlacht!", "6"},

                {"6", "8", "Es ist Zeit zu gehen", "Du versuchst zu flüchten, doch das Monster verfolgt dich.", "0"},

                {"-1", "9", "", "Deine Zeit ist leider vorüber. Der Tod erwartet dich schon mit freundlichem Grinsen", "9"}, // TOD

                {"-1", "10", "", "Du bist der größte Held aller Zeiten! Hurra!", "10"}, // SIEG
        };
        int lifeMax = 10;                           //max. Lebenspunkte d. Spielers, startend bei 10
        int pLife = 10;                             //Momentane Lebenspunkte des Spielers, startend bei lifeMax
        int mLife = 0;    //Lebenspunkte des Monsters started bei einem Random Wert von 3 - 20
        int pAttack = 0;      //max. Angriffskraft d. Spielers, random von 1 bis pLife
        int mAttack = 0;      //max. Angriffskraft d. Monsters, random von 1 bis mLife
        int pGold = 0;                               //Goldmünzen, Spieler started bei 0
        int mGold = 0;


        int currentChoice = 0;  //Orientiert sich an die parentID und gibt an in welchem "Raum" des Spieles man ist.
        int checkParentId; // Variable um ParentId in Int umzuwandeln...wird später verwendet, um zu überprüfen: wenn currentChoice mit der checkParentId übereinstimmt, dann zeige NUR die Möglichkeiten an, die einem an diesem Punkt im Enteidungsbaum zustehen.
        int possibleChoices; // Variable um ID in einer ArrayList zu speichern. Wenn currentChoice mit der checkParentID übereinstimmt, dann werden nur diese Werte in die ArrayList gespeichert.

        while (currentChoice < choices.length - 2) {

            if (currentChoice == 4) {
                mLife = r.nextInt(3, 20);    //Lebenspunkte des Monsters started bei einem Random Wert von 3 - 19
                pAttack = r.nextInt(1, pLife);      //max. Angriffskraft d. Spielers, random von 1 bis pLife
                mAttack = r.nextInt(1, mLife);      //max. Angriffskraft d. Monsters, random von 1 bis mLife
                mGold = (r.nextInt(1, mLife) * 100);
                choices[currentChoice][3] = ("Das Monster hat insgesamt " + mLife + " Leben, und du noch " + pLife + "!");
            }

            System.out.println(choices[currentChoice][3]);      //Ausgabe Erste Zeile, in welchem Raum der Spieler steht


            switch (currentChoice) {

                case 2:
                    if (pGold >= 100) {
                        pLife += 3;
                        pGold -= 100;
                        if (pLife > lifeMax) {
                            pLife = lifeMax;
                        }
                        System.out.println("\nDein Lebensdurst kehrt zurück! +3 Leben, jetzt hast du wieder " + pLife + " Leben!");
                    }
                    break;

                case 3:
                    if (pGold >= 1000 && lifeMax >= 15) {
                        currentChoice = 10;
                    }
                    if ((pGold < 1000 && lifeMax < 15) || (pGold < 1000 || lifeMax < 15)) {
                        System.out.println("\nDie Prinzessin belächelt dich nur verächtlich. So einen armen Schlucker soll sie heiraten? Und so wenig Lebenserfahrung! Tz tz!");
                        System.out.println("HAHA Dir fehlen noch sicher " + (1000 - pGold) + " Gold dafür, Junge! Und " + (15 - lifeMax) + " Jahre Erfahrung!");
                    }
                    break;

                case 7:
                    if (pLife > 0) {
                        mLife = mLife - pAttack;
                        System.out.println("\nDu erwischt das Monster mit " + pAttack + " Schaden. Es hat noch " + mLife + " Leben.");
                    }
                    if (mLife > 0) {
                        pLife = pLife - mAttack;
                        System.out.println("Das Monster hat dich für " + mAttack + " Schaden erwischt. Du hast noch " + pLife + " Leben.");
                    }

                    if (pLife <= 0) {
                        currentChoice = 9;
                    }
                    if (mLife <= 0) {
                        lifeMax++;
                        pGold += mGold;
                        System.out.println("Du hast das Monster besiegt!");
                        System.out.println("Du gewinnst an Erfahrung und hast jetzt mehr maximale Lebenspunkte");
                        System.out.println("Du findest in der Nähe des Monsters " + mGold + " Gold - das du dir natürlich schnappst!\n");
                        currentChoice = 1;
                        System.out.println(choices[currentChoice][3]);
                    }
                    break;

                case 8:
                    pLife -= mAttack;
                    if (pLife <= 0) {
                        currentChoice = 9;
                    }
                    System.out.println("Du verlierst " + mAttack + " Leben und hast nur noch " + pLife);
                    break;
            }

            if (choices[currentChoice].length > 4) {
                currentChoice = Integer.parseInt(choices[currentChoice][4]);
                if (!choices[currentChoice][3].equals("")) {
                    System.out.println(choices[currentChoice][3]);
                } else {
                    System.out.print(choices[currentChoice][3]);
                }

            }

            if (currentChoice < choices.length - 2) {

                System.out.println("-".repeat(30));         //Ausgabe 2 Zeile (Striche)

                for (int x = 0; x < choices.length; x++) {
                    checkParentId = Integer.parseInt(choices[x][0]);
                    if (checkParentId == currentChoice) {
                        System.out.printf("%s.) ", x);                               //Ausgabe der nächsten Zeilen (Optionen), je nach dem in welchem Raum der Spieler ist
                        System.out.println(choices[x][2]);
                        possibleChoices = Integer.parseInt(choices[x][1]);
                        viableChoices.add(possibleChoices);
                    }
                }

                System.out.println("-".repeat(30));     //Ausgabe Striche

                viableChoices.add(100); //Um eine Option für den Abbruch zu haben
                do
                {                //Spieler bleibt so lange in Schleife drinnen, bis eine richtige Option ausgewählt wird
                    System.out.println("Was willst du als nächstes tun?");
                    currentChoice = sc.nextInt();
                } while (!viableChoices.contains(currentChoice));
            }
            viableChoices.clear(); //Array List mit verfügbaren Optionen wird Anfangs gelöscht, um clear zu bleiben
        }


    }

}
