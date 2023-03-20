import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class KinoVerwaltungV2 {
    public static void main(String[] args) {

        ArrayList<String> chosenMoviesList = new ArrayList<>();
        ArrayList<String> chosenSnacksList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        double price = 15;
        int chosenMovie;
        int chosenSnack;
        int watchMovie;
        int eatSnack;
        int howManyTickets;
        int howManySnacks;
        double costMovie;
        double costSnack;
        int option = 0;
        int lotteryWon = 0;
        int lotteryLost = 0;

        String[][] movies = {                                                      //movies [Zeile] [Spalte]
                {"Filmnr.", "Filmname", "Uhrzeit", "Saal", "Restplätze",},
                {"1.", "Batman", "20:15", "1", "5",},
                {"2.", "Matrix", "22:30", "3", "2",},
                {"3.", "Joker", "21:30", "2", "0",},
                {"4.", "John Wick", "19:45", "4", "8",},
                {"5.", "Black Panther 2", "23:45", "4", "1",},
                {"6.", "Spider Man", "23:45", "4", "6",},
        };

        String[][] snacks = {
                {"Nr.", "Snack", "Preis", "Auf Lager?"},
                {"1.", "Popcorn", "1.50", "5"},
                {"2.", "Chips", "2.00", "4"},
                {"3.", "Schoki", "1.30", "0"},
                {"4.", "Nachos", "3.50", "2"}
        };

        String[][] askUser = {
                {"1.", "Ticket kaufen",},
                {"2.", "Snacks kaufen",},
                {"3.", "Film anschauen",},
                {"4.", "Snacks essen",},
                {"5.", "Beim Gewinnspiel mitmachen (kostet 5€)"},
                {"6.", "Kino verlassen"},
        };

        System.out.println("Wie viel Geld hast du mit?");           //Benutzer legt am Anfang Fest mit wie viel Geld gerechnet wird...mindestens 15 € werden benötigt.

        double money = sc.nextDouble();
        DecimalFormat f = new DecimalFormat("#0.00");

        if (money > 0) {
            do {
                System.out.println("Was möchtest du als nächstes machen?");
                for (int i = 0; i < askUser.length; i++) {
                    System.out.println();
                    for (int j = 0; j < askUser[0].length; j++) {
                        System.out.printf(askUser[i][j]);
                    }
                }
                System.out.println();
                option = sc.nextInt();

                if (option == 1) {

                    //Beginn Schleife
                    do {
                        for (int i = 0; i < movies.length; i++) {
                            if (i == 1) {
                                System.out.print("\n" + "-".repeat(95));                   //Ausgabe des String-Arrays movies
                            }
                            System.out.println();
                            for (int j = 0; j < movies[0].length - 1; j++) {
                                System.out.printf("%-18s", movies[i][j]);
                            }
                            if (i == 0) {
                                System.out.print("Restplätze");
                            } else {
                                if (movies[i][4].equals("0")) {
                                    System.out.print("ausgebucht");
                                } else System.out.print("verfügbar");
                            }
                        }
                        System.out.println("\n" + "-".repeat(95));

                        System.out.println("\n Welchen (nicht ausgebuchten) Film möchtest du sehen? (Drücke O um abzubrechen)");
                        chosenMovie = sc.nextInt();

                        if (chosenMovie >= movies.length || chosenMovie < 0 || movies[chosenMovie][4].equals("0")) {    //Conditions...Film darf nicht ausgebucht sein + Sperre das irgendwelche Zahlen eingegeben werden --> loop
                            System.out.println("\n Bitte wähle einen Film lt. Liste aus, der auch nicht ausgebucht ist :|");
                        } else if (chosenMovie >= 1 && chosenMovie <= movies.length) {//Program läuft weiter wenn richtige Conditions
                            int seats = Integer.parseInt(movies[chosenMovie][4]);
                            System.out.println("Es sind noch " + seats + " Tickets um jeweils 15 € dafür verfügbar. Wie viele möchtest du kaufen?");
                            howManyTickets = sc.nextInt();
                            if (howManyTickets <= 0 || howManyTickets > seats) {
                                System.out.println("\n Bitte gib eine richtige Ticketanzahl ein :|");  //Condition - wenn Ticketwerte mit Minus eingegeben werden --> loop
                            } else if (howManyTickets > 0) {                                        //Erst wenn richtige Ticketwerte eingegeben werden, werden die Kosten berechnet
                                costMovie = howManyTickets * price;
                                if (costMovie > money) {                                                 //Condition - Die Kosten dürfen Money nicht übersteigen -->loop
                                    System.out.println("\n Du hast nicht genug Geld um " + howManyTickets + " Tickets zu kaufen...Wähle eine geringere Ticketanzahl");
                                } else {                                                            //Ist genug Geld da läuft Code weiter → die Kosten werden von Money abgezogen →gibt die Tickets in die ArrayList → StringArray wird aktualisiert
                                    money = money - costMovie;
                                    int seatsLeft = seats - howManyTickets;

                                    for (int x = 0; x < howManyTickets; x++) {
                                        chosenMoviesList.add(movies[chosenMovie][1]);               //Gibt die ausgewählten Filme in die ArrayList
                                    }
                                    movies[chosenMovie][4] = String.valueOf(seatsLeft);

                                    System.out.println("Du kaufst " + howManyTickets + " Ticket um " + costMovie + " € und hast jetzt nur noch " + f.format(money) + " €");
                                }
                            }
                        }
                    } while (chosenMovie != 0);
                    System.out.println("Gekaufte Tickets: \n" + chosenMoviesList); //Zeigt die ArrayList Werte an, wie oft ein Film gekauft wurde
                    System.out.println("\nBye from the movie section ^^\n");//END While-Schleife - End Program
                    option = 0;

                } else if (option == 2) {

                    do {
                        for (int i = 0; i < snacks.length; i++) {
                            if (i == 1) {
                                System.out.print("\n" + "-".repeat(50));                   //Ausgabe des String-Arrays movies
                            }
                            System.out.println();
                            for (int j = 0; j < snacks[0].length - 1; j++) {
                                System.out.printf("%-10s", snacks[i][j]);
                            }
                            if (i == 0) {
                                System.out.print("Auf Lager?");
                            } else {
                                if (snacks[i][3].equals("0")) {
                                    System.out.print("ausgebucht");
                                } else System.out.print("verfügbar");
                            }
                        }
                        System.out.println("\n" + "-".repeat(50));

                        System.out.println("\n Welchen (noch vorhandenen) Snack möchtest du kaufen?" + " Du hast noch " + f.format(money) + "€ übrig " + "(Drücke O um abzubrechen)");
                        chosenSnack = sc.nextInt();
                        if (chosenSnack >= snacks.length || chosenSnack < 0 || snacks[chosenSnack][3].equals("0")) {
                            System.out.println("Bitte wähle einen Snack lt Liste aus, der noch auf Lager ist");
                        } else if (chosenSnack >= 1 && chosenSnack <= snacks.length) {
                            int snackLeft = Integer.parseInt(snacks[chosenSnack][3]);
                            System.out.println("Es sind noch " + snackLeft + " " + snacks[chosenSnack][1] + " verfügbar. Wie viele möchtest du kaufen?");
                            howManySnacks = sc.nextInt();
                            if (howManySnacks <= 0 || howManySnacks > snackLeft) {
                                System.out.println("Bitte gib die richtige Anzahl an Snack ein, die du kaufen möchtest :|");
                            } else if (howManySnacks > 0) {
                                double priceSnack = Double.parseDouble(snacks[chosenSnack][2]);
                                costSnack = priceSnack * howManySnacks;
                                if (costSnack > money) {
                                    System.out.println("Du hast nicht genug Geld um " + howManySnacks + " " + snacks[chosenSnack][1] + " zu kaufen. Wähle etwas anderes");
                                } else if (costSnack < money) {
                                    money = money - costSnack;
                                    snackLeft = snackLeft - howManySnacks;
                                    for (int x = 0; x < howManySnacks; x++) {
                                        chosenSnacksList.add(snacks[chosenSnack][1]);
                                    }
                                    snacks[chosenSnack][3] = String.valueOf(snackLeft);
                                    System.out.println("Du kaufst " + howManySnacks + " " + snacks[chosenSnack][1] + " um " + costSnack + "€ und hast jetzt noch " + f.format(money) + "€ verfügbar.");
                                }
                            }
                        }


                    } while (chosenSnack != 0);
                    System.out.println("Gekaufte Snacks: \n" + chosenSnacksList);
                    System.out.println("Bye from the snack section ^^\n");
                    option = 0;
                } else if (option == 3) {

                    do {
                        System.out.println("Welchen Film (für den du noch ein Ticket hast) möchtest du sehen? (0 zum abbrechen)");

                        for (int x = 0; x < 1; x++) {
                            int j = 1;
                            System.out.println();
                            for (int y = 0; y < chosenMoviesList.size(); y++) {
                                System.out.print(j + ".");
                                System.out.println(chosenMoviesList.get(y));
                                j++;
                            }
                        }
                        //                System.out.println(chosenMoviesList);
                        do {
                            watchMovie = sc.nextInt() - 1;
                        } while (watchMovie >= chosenMoviesList.size() || watchMovie <= -2);
                        if (watchMovie >= 0) {
                            System.out.println("Du schaust dir den Film " + chosenMoviesList.get(watchMovie) + " an. Viel Spaß!\n");

                            chosenMoviesList.remove(watchMovie);
                            System.out.println("Folgende Tickets hast du noch übrig:\n" + chosenMoviesList + "\n");
                        }
                    } while (watchMovie != -1);
                } else if (option == 4) {
                    do {
                        System.out.println("Welchen Snack (den du gekauft hast) möchtest du essen? (0 zum abbrechen)");

                        for (int x = 0; x < 1; x++) {
                            int j = 1;
                            System.out.println();
                            for (int y = 0; y < chosenSnacksList.size(); y++) {
                                System.out.print(j + ".");
                                System.out.println(chosenSnacksList.get(y));
                                j++;
                            }
                        }
                        //                System.out.println(chosenSnacksList);
                        do {
                            eatSnack = sc.nextInt() - 1;
                        } while (eatSnack >= chosenSnacksList.size() || eatSnack <= -2);
                        if (eatSnack >= 0) {
                            System.out.println("Du isst deinen Snack " + chosenSnacksList.get(eatSnack) + ". Enjoy!\n");

                            chosenSnacksList.remove(eatSnack);
                            System.out.println("Folgende Snacks hast du noch übrig:\n" + chosenSnacksList + "\n");
                        }
                    } while (eatSnack != -1);
                } else if (option == 5) {

                    if (money >= 5) {
                        System.out.println("Du machst beim Gewinnspiel mit!");
                        int lotteryNumber = r.nextInt(200);
                        System.out.println("Deine Glückszahl ist: " + lotteryNumber + "\n");

                        int a = 1;
                        int b = 1;
                        int c = a + b;

                        if (lotteryNumber % 10 == 0) {
                            System.out.println(lotteryNumber + " ist duch 10 teilbar! Du gewinnst 20€ \n");
                            money = money + 15;
                            lotteryWon++;
                        } else {

                            for (int x = 1; x <= 11; x++) {
                                c = a + b;

                                System.out.println(a + " + " + b + " = " + c);
                                a = b;
                                b = c;

                                if (lotteryNumber == c) {
                                    x = 12;
                                    System.out.println(lotteryNumber + " ist eine Fibonaccy-Nummer! Du gewinnst 20€\n");
                                    money = money + 15;
                                    lotteryWon++;
                                } else if (lotteryNumber != c && lotteryNumber <= c) {
                                    x = 12;
                                    System.out.println(lotteryNumber + " ist Keine Fibonacci-Nummber und auch nicht durch 10 teilbar! Leider nicht gewonnen :'(\n");
                                    money = money - 5;
                                    lotteryLost++;
                                }
                            }
                        }


                    } else if (money < 5) {
                        System.out.println("Du hast leider nicht genug Geld :'( - du benötigst mindestens 5€.");
                    }
                }//If Case 1,2,3,4,5,


            } while (option != 6);

            System.out.println("Übrige Snacks:\n" + chosenSnacksList);
            System.out.println("Übrige Tickets:\n" + chosenMoviesList);
            System.out.println("Du hast " + lotteryWon + "x gewonnen und " + lotteryLost + "x beim Gewinnspiel verloren. Ergebnis: " + ((lotteryWon * 15) - (lotteryLost * 5)) + "€ Gewinn/Verlust");
            System.out.println("Du hast noch " + f.format(money) + "€ übrig\n");
            System.out.println("Bye :'(...\nSee you another time\n");
        }
    }
}
