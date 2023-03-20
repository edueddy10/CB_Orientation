import java.util.Scanner;
import java.util.Random;

public class MinesweeperV1 {
    public static void main(String[] args) {

        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[10][10];

        int count = 0;
        int row;
        int column;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {       //Befüllung der Map
                map[i][j] = r.nextInt(4) * -1;
            }
        }

        do {
            char mapIndex = 65;
            int mapIndexNo = 0;
            int mineCount = 0;

            System.out.println("Wo willst du nach Minen suchen?");
            char[] inputTake = sc.next().toUpperCase().toCharArray();
            System.out.println(inputTake[0] - 65);
            System.out.println(inputTake[1]);

            row = inputTake[0] - 'A';
            column = inputTake[1] - '0';
            count++;

            for (int x = 0; x < map.length; x++) {
                System.out.printf("%5s", mapIndexNo);        // Ausgabe der Zahlen über der Map
                mapIndexNo++;
            }
            for (int i = 0; i < map.length; i++) {
                System.out.println();
                System.out.print(mapIndex + " ");           // Ausgabe der Map und der Buchstaben links von der Map
                mapIndex++;
                for (int j = 0; j < map.length; j++) {

                    if (map[row][column] == 0) {
                        map[row][column] = -5;
                    }
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

            System.out.println("\nEs bleiben " + mineCount + " Minen im Feld");
            System.out.print("Du hast " + count + "/75 (");
            System.out.printf("%.2f", ((float) count / 75 * 100));
            System.out.print("%) Feldern auf Minen gecheckt\n");
        } while (map[row][column] != -5);

    }
}
