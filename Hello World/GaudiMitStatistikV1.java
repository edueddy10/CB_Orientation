public class GaudiMitStatistikV1 {
    public static void main(String[] args) {

        String s = "Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!";
        int x = 1;
        int capitalLetter = 0;
        int letters = 0;
        int numbers =0;
        int specialChar = 0;

        char [ ] myArr = s.toCharArray();


        for (x = 0; x < myArr.length; x++) {

            if (myArr[x] >= 65 && myArr[x] < 91) {
                capitalLetter++;
            }
            else if (myArr[x] >= 97 && myArr[x] < 123) {
                letters++;
            }
            else if (myArr[x] >= 48 && myArr[x] < 58) {
                numbers++;
            }
            else if ((myArr[x] >= 32 && myArr[x] < 48) ||
                    (myArr[x] >=58 && myArr[x] < 65) ||
                    (myArr[x] >= 91 && myArr[x] < 97) ||
                    (myArr[x] >= 123 && myArr[x] < 127)) {
                specialChar++;
            }
        }
        System.out.println("Grossbuchstaben: " + capitalLetter);
        System.out.println("Kleinbuchstaben: " + letters);
        System.out.println("Zahlen: " + numbers);
        System.out.println("Sonstige Zeichen: " + specialChar);
    }
}
