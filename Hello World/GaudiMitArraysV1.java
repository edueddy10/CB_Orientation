import java.util.Random;

public class GaudiMitArraysV1 {
    public static void main(String[] args) {
        //Array mit 10 "Boxen" von 1 bis 10 wurde angelegt...die Box 4 mit dem Wert 5 wird dann dargestellt
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(x[4]);

        // Array mit 100 "Boxen" werden mit 100 random int Werten befüllt:
        Random r = new Random();
        int[] y = new int[100];

        for (int z = 0; z < y.length; z++) {
            y[z] = r.nextInt(101);
        }
        System.out.println(y[0] + " Ein Random Wert zwischen 0-100 wird hier dargestellt");

        //Array mit boolean Werten die abwechselnd false und true sind:
        boolean[] a = new boolean[10];

        for (int z = 1; z < a.length; z++) {
            if (z % 2 == 0) {
                a[z] = false;
            } else a[z] = true;

        }
        for (int f = 0; f < a.length; f++) {
            System.out.println(a[f]);
        }
    }
}
