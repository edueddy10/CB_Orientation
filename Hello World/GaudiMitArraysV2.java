public class GaudiMitArraysV2 {
    public static void main(String[] args) {

        char firstLetter = 65;
        int howMuch = 60;

        howMuch = howMuch % 26;

        char [] countalphabet = new char[26];

        for (int x = 0; x < countalphabet.length; x++) {

            countalphabet[x] = firstLetter;
            countalphabet[x] += howMuch;
            firstLetter++;

            if (countalphabet[x] > 90) {
                countalphabet[x] -= 26;
            } else if (countalphabet[x] < 65) {
                countalphabet[x] += 26;
            }

        }
        for (int x = 0; x < countalphabet.length; x++) {
            System.out.print(countalphabet[x]);
        }
    }
}
