import java.util.Random;

public class GaudiMitStatistikV2 {
    public static void main(String[] args) {

        int[] numbers = new int[100];
        int x = 0; //x befüllt die Werte
        int y = 0; //y gibt die Erste Ausgabezeile aus
        int c = 0; //ist eine zwischenvariable
        int a = 0;
        int b = 0;
        Random r = new Random();

//Befüllung des Arrays numbers mit 100 random Werten zwischen 0 und 100:
        for (x = 0; x < numbers.length; x++) {

            numbers[x] = r.nextInt(101);
        }
// Ausgabe der Ersten Random Schleife:
        for (y = 0; y < numbers.length; y++) {
            System.out.print(numbers[y] + " ");
        }
// Sortierung des int-Arrays numbers:
        for (a = 0; a < numbers.length; a++) {
            for (b = a + 1; b < numbers.length; b++) {
                if (numbers[a] > numbers[b]) {
                    c = numbers[a];
                    numbers[a] = numbers[b];
                    numbers[b] = c;
                }
            }
        }
        //sortierung erfolg folgendermasen: Beispiel: numbers[a=0] = 5 und numbers [b=a+1 also 1] = 3....wenn numbers[a] größer als numbers[b] dann
        //speichere den Wert von numbers [0] in die Variable c = 5...
        //der Wert von numbers [0] wird dann zum Wert von numbers [1] also 5 wird zu 3...und der Wert numbers [1] wird zum Wert der Variable c...also 5...das ganze wiederholt sich für 100 mal usw...

// Ausgabe der Zweiten sortierten Random Schleife:
        System.out.println("");
        for (y = 0; y < numbers.length; y++) {
            System.out.print(numbers[y] + " ");
        }
    }
}
