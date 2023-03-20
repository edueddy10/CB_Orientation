import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class MinesweeperV2 {
    public static void main(String[] args) {

        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[10][10];
        ArrayList<String> madeChoices = new ArrayList<>();
        boolean control = true;

        int count = 0;
        int row;
        int column;

        char mapIndex = 'A';
        int mapIndexNo = 0;
        int mineCount = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {       //Befüllung der Map
                map[i][j] = r.nextInt(4) * -1;
            }
        }

        for (int x = 0; x < map.length; x++) {
            System.out.printf("%5s", mapIndexNo);        // Ausgabe der Zahlen über der Map
            mapIndexNo++;
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println();
            System.out.print(mapIndex + " ");           // Ausgabe der Map und der Buchstaben links von der Map
            mapIndex++;
            for (int j = 0; j < map.length; j++) {
                System.out.printf("[%2s ]", "" /*map[i][j]*/);
            }
        }

        do {
            mapIndex = 'A';
            mapIndexNo = 0;
            mineCount = 0;
            char[] inputTake = new char[2];

            System.out.println("\nWo willst du nach Minen suchen?");
            do {
                inputTake = sc.next().toUpperCase().toCharArray();

                try {
                    if (madeChoices.contains(Character.toString(inputTake[0]) + Character.toString(inputTake[1]))) {
                        System.out.println("Dieses Feld wurde bereits gewählt :|\nWähle ein anderes");
                    }
                } catch (Exception e) {
                    do {
                        System.out.println("Du hast eine falsche Eingabe >:(\nProbiere nochmal");
                        inputTake = sc.next().toUpperCase().toCharArray();
                        if (inputTake.length == 2) {
                            control = false;
                        }
                    }while (control == true);
                }

            } while (madeChoices.contains(Character.toString(inputTake[0]) + Character.toString(inputTake[1])));
            madeChoices.add(Character.toString(inputTake[0]) + Character.toString(inputTake[1]));
            System.out.println(inputTake[0] - 65);
            System.out.println(inputTake[1]);

            row = inputTake[0] - 'A';
            column = inputTake[1] - '0';

            try {

                if (map[row][column] == 0) {
                    map[row][column] = -5;
                }

                for (int x = 0; x < map.length; x++) {
                    System.out.printf("%5s", mapIndexNo);        // Ausgabe der Zahlen über der Map
                    mapIndexNo++;
                }

                for (int i = 0; i < map.length; i++) {
                    System.out.println();
                    System.out.print(mapIndex + " ");           // Ausgabe der Map und der Buchstaben links von der Map
                    mapIndex++;
                    for (int j = 0; j < map.length; j++) {

                        if (map[row][column] == -1 || map[row][column] == -2 || map[row][column] == -3) {
                            map[row][column] = -4;
                        }

                        if (map[i][j] == 0 || map[i][j] == -1 || map[i][j] == -2 || map[i][j] == -3) {
                            System.out.printf("[%2s ]", "" /*map[i][j]*/);
                        }
                        if (map[i][j] == -5) {
                            System.out.printf("[%2s ]", "*" /*map[i][j]*/);
                        }
                        if (map[i][j] == -4) {
                            System.out.printf("[%2s ]", "-" /*map[i][j]*/);
                        }
                        if (map[i][j] == 0) {
                            mineCount++;
                        }
                    }
                }
                System.out.println();

                count++;
                System.out.println("\nEs bleiben " + mineCount + " Minen im Feld");
                System.out.print("Du hast " + count + "/75 (");
                System.out.printf("%.2f", ((float) count / 75 * 100));
                System.out.print("%) Feldern auf Minen gecheckt\n");

            } catch (Exception e) {
                System.out.println("Du hast eine falsche Eingabe >:(");
                column = 0;
                row = 0;
            }

        } while (map[row][column] != -5);

    }
}
