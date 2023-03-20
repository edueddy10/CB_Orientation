public class PseudoCode {
    public static void main(String[] args) {

        int isMyNumberPrim = 14; //zu überprüfende Nummer hier eingeben
        int dividend;
        boolean prim = true;

        //Berechnung ob isMyNumberPrim eine Primzahl ist:
        for (dividend = 2; (dividend < isMyNumberPrim) && (prim); dividend++) {
            if (isMyNumberPrim % dividend == 0)
                prim = false;
        }
        //Ausgabe:
        if (prim) {
            System.out.println("Die Zahl " + isMyNumberPrim + " ist eine Primzahl!");
        }
        else
            System.out.println("Die Zahl " + isMyNumberPrim + " ist KEINE Primzahl!");
    }
}
