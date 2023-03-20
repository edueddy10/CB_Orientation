import java.util.Scanner;

public class KinoVerwaltunV1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int price = 15;
        char abort = 'A';
        int ticketBuy = 0;
        int money = 0;
        int cost = ticketBuy * price;
        int moneyLeft = money - (cost);
        int seatsLeft1 = 30; boolean seatsAvailable1 = true;
        int seatsLeft2 = 20; boolean seatsAvailable2 = true;
        int seatsLeft3 = 0; boolean seatsAvailable3 = true;




        String[][] listOfMovies = {                                                             //listOfMovies [Zeile] [Spalte]
                {"Filmnr", "Filmname", "Uhrzeit", "Saal", " Restplätze" },
                {"-".repeat(60), "", "", "", "" },
                {"1.", "Batman", "20:15", "1", "verfügbar" },
                {"2.", "Matrix", "22:30", "3", "verfügbar " },
                {"3.", "John Wick", "17:00", "2", "ausgebucht" },
        };


        while (abort != 'O') { //while Schleife beginn

            if (seatsLeft1 > 0) {
                seatsAvailable1 = true;
            } else seatsAvailable1 = false;

            if (seatsLeft2 > 0) {
                seatsAvailable2 = true;
            } else seatsAvailable2 = false;

            if (seatsLeft3 > 0) {
                seatsAvailable3 = true;
            } else seatsAvailable3 = false;



            for (int i = 0; i < listOfMovies.length; i++) {
                System.out.println();
                for (int j = 0; j < listOfMovies.length; j++) {
                    System.out.printf("%-12s", listOfMovies[i][j]);
                }
            }
            System.out.println("\n" + "-".repeat(60));

            if (!seatsAvailable1 && !seatsAvailable2 && !seatsAvailable3) {
                System.out.println("Sorry, wir sind leider komplett ausgebucht :'(...Drücke 0...");
                abort = 'O';
                sc.nextLine();
            }else

            System.out.println("Wie viel Geld hast du mit?");
            money = sc.nextInt();
            if (money >=15) {

            System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
            int movie = sc.nextInt();

            if (movie < 1) {
                abort = 'O';
                sc.nextLine();
            }else if ((movie == 1 && !seatsAvailable1) || (movie == 2 && !seatsAvailable2) || (movie == 3 && !seatsAvailable3)) {
                    System.out.println("Sorry der Saal ist leider ausgebucht. Wähle einen anderen Film ;) \n \n");

                                                                                                                                                                            //wenn kleiner gleich 0 eingegeben wird --> Programm endet hier ansonsten
            }else if ((movie == 1 && seatsAvailable1) || (movie == 2 && seatsAvailable2) || (movie == 3 && seatsAvailable3)) {              //wiederholt das Programm die Frage wie viel Geld wenn mehr als 3 eingegeben wird.

                switch (movie) {

                    case 1:
                        System.out.println("Es sind noch " + seatsLeft1 + " Tickets für jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen?");
                        ticketBuy = sc.nextInt();
                        cost = price * ticketBuy;
                        moneyLeft = money - cost;
                        if (cost <= money) {
                            System.out.println("Du kaufst " + ticketBuy + " Tickets um " + cost + "€ und hast jetzt nur noch " + moneyLeft + "€");
                            seatsLeft1 -= ticketBuy;
                        }else System.out.println("Sorry du hast nicht genug Geld für " + ticketBuy + " Tickets");
                        break;
                    case 2:
                        System.out.println("Es sind noch " + seatsLeft2 + " Tickets für jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen?");
                        ticketBuy = sc.nextInt();
                        cost = price * ticketBuy;
                        moneyLeft = money - cost;
                        if (cost <= money) {
                            System.out.println("Du kaufst " + ticketBuy + " Tickets um " + cost + "€ und hast jetzt nur noch " + moneyLeft + "€");
                            seatsLeft2 -= ticketBuy;
                        }else System.out.println("Sorry du hast nicht genug Geld für " + ticketBuy + " Tickets");
                        break;
                    case 3:
                        System.out.println("Es sind noch " + seatsLeft3 + " Tickets für jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen?");
                        ticketBuy = sc.nextInt();
                        cost = price * ticketBuy;
                        moneyLeft = money - cost;
                        if (cost <= money) {
                            System.out.println("Du kaufst " + ticketBuy + " Tickets um " + cost + "€ und hast jetzt nur noch " + moneyLeft + "€");
                            seatsLeft3 -= ticketBuy;
                        }else System.out.println("Sorry du hast nicht genug Geld für " + ticketBuy + " Tickets");
                        break;
                    default:
                        sc.nextLine();
                }
                if (seatsLeft1 <= 0) {
                    listOfMovies[2][4] = "ausgebucht";
                }
                if (seatsLeft2 <= 0) {
                    listOfMovies[3][4] = "ausgebucht";
                }
                if (seatsLeft3 <= 0) {
                    listOfMovies[4][4] = "ausgebucht";
                }



            }
            }
            } //while Schleife Ende




        }
}
