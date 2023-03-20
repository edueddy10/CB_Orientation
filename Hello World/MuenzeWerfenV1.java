import java.util.Random;

public class MuenzeWerfenV1 {
    public static void main(String[] args) {

      Random r = new Random();

      boolean kopf = r.nextBoolean(); //ist ein zufälliger Wert von ture oder false

        System.out.println(kopf);

        if (kopf == true) {
            System.out.println("Die Münze ist auf Kopf gelandet - ich gewinne");
        }
        else {
            System.out.println("Die Münze ist auf Zahl gelandet - Stefan gewinnt");
        }

    }
}
