import java.util.Scanner;
import java.util.ArrayList;

public class KinoVerwaltungV1_2 {
    public static void main(String[] args) {

        ArrayList<String> chosenMoviesList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        int price = 15;
        int chosenMovie = 0;
        int howManyTickets = 0;
        int cost = 0;

        String[][] movies = {                                                      //movies [Zeile] [Spalte]
                {"Filmnr.", "Filmname", "Uhrzeit", "Saal", " Restplätze",},
                {"1.", "Batman", "20:15", "1", "30",},
                {"2.", "Matrix", "22:30", "3", "20",},
                {"3.", "Joker", "21:30", "2", "0",},
                {"4.", "John Wick", "19:45", "4", "8",},
                {"5.", "Black Panther 2", "23:45", "4", "15",},
                {"6.", "Spider Man", "23:45", "4", "18",},
        };

        System.out.println("Wie viel Geld hast du mit?");           //Benutzer legt am Anfang Fest mit wie viel Geld gerechnet wird...mindestens 15 € werden benötigt.
        int money = sc.nextInt();

//        while (money >= 15) {                                       //Beginn Schleife
        do{
            for (int i = 0; i < movies.length; i++) {
                if (i == 1) {
                    System.out.print("\n" + "-".repeat(95));                   //Ausgabe des String-Arrays movies
                }
                System.out.println();
                for (int j = 0; j < movies[0].length; j++) {
                    System.out.printf("%-20s", movies[i][j]);
                }
            }
            System.out.println("\n" + "-".repeat(95));

            System.out.println("\n Welchen (nicht ausgebuchten) Film möchtest du sehen? (Drücke O um abzubrechen)");
            chosenMovie = sc.nextInt();

            if(chosenMovie > movies.length || chosenMovie < 0 || movies[chosenMovie][4].equals("0")) {    //Conditions...Film darf nicht ausgebucht sein + Sperre das irgendwelche Zahlen eingegeben werden --> loop
                    System.out.println("\n Bitte wähle einen Film lt. Liste aus, der auch nicht ausgebucht ist :|");
            } else if (chosenMovie >= 1 && chosenMovie <= movies.length) {                                       //Program läuft weiter wenn richtige Conditions
                int seats = Integer.parseInt(movies[chosenMovie][4]);
                System.out.println("Es sind noch " + seats + " Tickets um jeweils 15 € dafür verfügbar. Wie viele möchtest du kaufen?");
                howManyTickets = sc.nextInt();
                if (howManyTickets <= 0 || howManyTickets > seats) {
                    System.out.println("\n Bitte gib eine richtige Ticketanzahl ein :|");  //Condition - wenn Ticketwerte mit Minus eingegeben werden --> loop
                } else if (howManyTickets > 0) {                                        //Erst wenn richtige Ticketwerte eingegeben werden, werden die Kosten berechnet
                    cost = howManyTickets * price;
                    if (cost > money) {                                                 //Condition - Die Kosten dürfen Money nicht übersteigen -->loop
                            System.out.println("\n Du hast nicht genug Geld um " + howManyTickets + " Tickets zu kaufen...Wähle eine geringere Ticketanzahl");
                    } else {                                                            //Ist genug Geld da läuft Code weiter → die Kosten werden von Money abgezogen →gibt die Tickets in die ArrayList → StringArray wird aktualisiert
                        money = money - cost;
                        int seatsLeft = seats - howManyTickets;

                        for (int x = 0; x < howManyTickets; x++) {
                            chosenMoviesList.add(movies[chosenMovie][1]);               //Gibt die Anzahl der ausgewählten Filme in die ArrayList
                        }

                            movies[chosenMovie][4] = String.valueOf(seatsLeft);
                            System.out.println("Du kaufst " + howManyTickets + " Ticket um " + cost + " € und hast jetzt nur noch " + money + " €");
                    }
                }
            }
        }while (chosenMovie !=0);
        System.out.println("Gekaufte Tickets: \n" + chosenMoviesList); //Zeigt die ArrayList Werte an, wie oft ein Film gekauft wurde
        System.out.println("\nBye :'(");//END While-Schleife - End Program
    }
}
