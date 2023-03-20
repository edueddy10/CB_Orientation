import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int level;

        //Level 1 variables:
        int pickNumberLv1;
        int triesLv1 = 0;
        //Level 1 variables end

        //Level 2 variables:
        int pickNumberLv2;
        int triesLv2 = 0;
        ArrayList<Integer> picksLv2 = new ArrayList<>();
        //Level 2 variables end

        //Level 3 variables:
        ArrayList<Integer> pickedNumbersLv3 = new ArrayList<>();
        boolean userStartsFirst = true;
        int pickNumberLv3;
        int min = 0;
        int max = 100;
        //Level 3 variables end
        //Level 4 variables:

        //Level 4 variables end

        do {
            System.out.println("Level 1 - ezz \nLevel 2 - not bad \nLevel 3 - boss level");
            System.out.println("Welches Level möchtest du spielen? (0 zum abbrechen)");
            level = sc.nextInt();

            if (level == 1) {
                triesLv1 = 0;
                int randomNumberLv1 = r.nextInt(101);
                for (int x = 0; x < 9; x++) {
                    System.out.println("Du hast " + (9 - triesLv1)  + " Versuche um eine Zahl zwischen 0 - 100 zu erraten. Viel Glück ;)");

                    while (!sc.hasNextInt()) {
                        sc.next();
                    }
                    pickNumberLv1 = sc.nextInt();

                    if (pickNumberLv1 > randomNumberLv1) {
                        System.out.println("Die Zahl nach der du Suchst ist kleiner als deine Eingabe: " + pickNumberLv1);
                    }
                    if (pickNumberLv1 < randomNumberLv1) {
                        System.out.println("Die Zahl nach der du Suchst ist größer als deine Eingabe: " + pickNumberLv1);
                    }

                    if (pickNumberLv1 == randomNumberLv1) {
                        x = 10;
                        System.out.println("Du hast die Zahl erraten und gewonnen. Möchtest du nochmal spielen?\n");
                    } else if (pickNumberLv1 != randomNumberLv1) {
                        System.out.println("Sorry...leider falsch geraten\n");
                    }
                    triesLv1++;
                }
                if (triesLv1 >= 9) {
                    System.out.println("Du hast keine Versuche mehr\n Möchtest du nochmal spielen?");
                }

            }

            if (level == 2) {
                triesLv2 = 0;
                int randomNumberLv2 = r.nextInt(101);
                for (int x = 0; x < 9; x++) {
                    System.out.println("Du hast " + (9 - triesLv2)  + " Versuche um eine Zahl zwischen 0 - 100 zu erraten. Viel Glück ;)");
                    pickNumberLv2 = sc.nextInt();


                    if (pickNumberLv2 >= randomNumberLv2 - 3 && pickNumberLv2 <= randomNumberLv2 -1)    {
                        System.out.println("fast da: zwischen 1 und 3 darunter daneben.");
                    }
                    else if (pickNumberLv2 <= randomNumberLv2 + 3 && pickNumberLv2 >= randomNumberLv2 +1)    {
                        System.out.println("fast da: zwischen 1 und 3 darüber daneben.");
                    }


                    if (pickNumberLv2 >= randomNumberLv2 - 10 && pickNumberLv2 <= randomNumberLv2 - 4)  {
                        System.out.println("relativ nahe: zwischen 4 und 10 darunter daneben");
                    }
                    else if (pickNumberLv2 <= randomNumberLv2 + 10 && pickNumberLv2 >= randomNumberLv2 + 4)  {
                        System.out.println("relativ nahe: zwischen 4 und 10 darüber daneben");
                    }


                    if (pickNumberLv2 >= randomNumberLv2 - 20 && pickNumberLv2 <= randomNumberLv2 - 11) {
                        System.out.println("Nicht ganz so weit weg: zwischen 11 und 20 darunter daneben.");
                    }
                    else if (pickNumberLv2 <= randomNumberLv2 + 20 && pickNumberLv2 >= randomNumberLv2 +11)  {
                        System.out.println("Nicht ganz so weit weg: zwischen 11 und 20 darüber daneben.");
                    }


                    if (pickNumberLv2 < randomNumberLv2 - 20) {
                        System.out.println("Weit weg: unter 20 daneben");
                    }
                    else if (pickNumberLv2 > randomNumberLv2 + 20) {
                        System.out.println("Weit weg: über 20 daneben");
                    }


                    if (pickNumberLv2 == randomNumberLv2) {
                        x = 10;
                        System.out.println("Du hast die Zahl erraten und gewonnen. Möchtest du nochmal spielen?\n");
                    } else if (pickNumberLv2 != randomNumberLv2) {
                        System.out.println("Sorry...leider falsch geraten\n");
                    }

                    picksLv2.add(pickNumberLv2);
                    System.out.println("Folgende Tips hast du bereits abegeben:\n" + picksLv2 + "\n");
                    triesLv2++;
                }
                if (triesLv2 >= 9) {
                    System.out.println("Du hast keine Versuche mehr\nMöchtest du nochmal spielen?");
                }
            }

            if (level == 3) {

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
                        } else if (pickNumberLv3 > randomNumberLv3) {
                            System.out.println("Die Nummer nach der gesucht wird ist kleiner als deine Eingabe: " + pickNumberLv3);
                        }

                        if (pickNumberLv3 < randomNumberLv3 && !pickedNumbersLv3.contains(pickNumberLv3)) {
                            min = pickNumberLv3;
                        } else if (pickNumberLv3 > randomNumberLv3 && !pickedNumbersLv3.contains(pickNumberLv3)) {
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
                    System.out.println("\nDie Zahl wurde Erraten\nMöchtest du nochmal spielen?");

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
                            } else if (pickNumberLv3 > randomNumberLv3) {
                                System.out.println("Die Nummer nach der gesucht wird ist kleiner als deine Eingabe: " + pickNumberLv3);
                            }

                            if (pickNumberLv3 < randomNumberLv3 && !pickedNumbersLv3.contains(pickNumberLv3)) {
                                min = pickNumberLv3;
                            } else if (pickNumberLv3 > randomNumberLv3 && !pickedNumbersLv3.contains(pickNumberLv3)) {
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
                    System.out.println("\nDie Zahl wurde Erraten\n Möchtest du nochmal spielen?");
                }

            }

            if (level == 4) {



            }

            if (level < 0 || level > 3) {
                System.out.println("Bitte gib eine korrekte Levelnummer ein du honk >:|");
            }

        } while (level != 0);

    }
}
