import java.util.Random;

public class GaudiMitStatistikV3 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] list = new int[10];

        for (int x = 0; x < list.length; x++) {
            list[x] = r.nextInt(1, 10); //Befüllung des Arrays mit Random Werten
        }
        System.out.println("Urliste:");
        for (int x = 0; x < list.length; x++) {     // Ausgabe
            System.out.printf("[%d]", list[x]);
        }
        //Sortieren:
        System.out.println("\nAufsteigend sortiert:");
        /*for (int x = 0; x < list.length; x++) {
            for (int y = 0; y < list.length; y++) {
                if (list[x] < list[y]) {
                    c = list[x];
                    list[x] = list[y];
                    list[y] = c;
                }
            }
        }*/
        int bigger;
        for (int x = 0; x < list.length - 1; x++) {
            if (list[x] > list[x + 1]) {
                bigger = list[x];
                list[x] = list[x + 1];
                list[x + 1] = bigger;
                x = -1;
            }
        }

        for (int x = 0; x < list.length; x++) {         //Ausgabe sortierte Liste
            System.out.printf("[%d]", list[x]);
        }
        //Sortieren END

        //Mittelwert:
        System.out.print("\nArithmetisches Mittel:");
        int sum = 0;
        for (int x = 0; x < list.length; x++) {
            sum += list[x];
        }
        int avrg = sum / list.length;
        System.out.print(avrg);
        //Mittelwert END

        //Spannweite:
        int max = list[list.length-1];
        int min = list[0];
        System.out.println("\nSpannweite: " + (max - min));
        //Spannweite END

        //Median:
        System.out.print("Median:");
        if (list.length % 2 != 0) {
            System.out.printf("[%d]", list[list.length / 2]);
        } else {
            double g = list[list.length / 2 - 1];
            double h = list[list.length / 2];
            double a = (g + h) / 2;
            System.out.print(g + " + " + h + " = " + a);
        }
        //Median END

        //ModalWert:
        int modalWert = 0;
        int maxOccurences = 1; // Occurence, wenn eine Zahl öfters als 1 Mal vorkommt
        int count = 0;
        //Steht für "Suche die Liste durch."
/*
        for (int x = 0; x < list.length; x++) {
            d = list[x];
            count = 0;
            for (int y = 0; y < list.length; y++) {
                if (d == list[y]) {
                    count++;
                }
                if (count > modalWertOccurence) {
                    modalWert = d;
                    modalWertOccurence = count;
                }
            }
        }
        */
        for (int x = 1; x < list.length; x++) {
            if (list[x] == list[x - 1]) {
                count++;
            }
            if (list[x] != list[x - 1]) {

                if (count > maxOccurences) {
                    modalWert = list[x-1];
                    maxOccurences = count;
                }
                count = 1;
            }
        }
        System.out.println("\nModalwert: " + modalWert + " mit " + maxOccurences);
        //Modalwert END

        //Mean deviation - mittlere absolute Abweichung:
        double md = 0;
        for (int x = 0; x < list.length; x++) {
            md += Math.abs((list[x] - avrg));
        }
        System.out.printf("Mittlere absolute Abweichung: %.2f", (md / list.length));
        //END
    }
}
