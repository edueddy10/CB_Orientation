import java.util.ArrayList;
import java.util.Random;
public class CyberSecurityV1_2 {
    public static void main(String[] args) {

        Random r = new Random();
        String[] charsGeneratePassword = {"A", "B", "C", "a", "b", "c", "0", "1", "2", "!"};
        ArrayList<String> randomPasswordList = new ArrayList<>();

        for (int a = 0; a < charsGeneratePassword.length; a++) {
            for (int b = 0; b < charsGeneratePassword.length; b++) {
                for (int c = 0; c < charsGeneratePassword.length; c++) {
                    for (int d = 0; d < charsGeneratePassword.length; d++) {
//                            System.out.print(charsGeneratePassword[a]);
//                            System.out.print(charsGeneratePassword[b]);
//                            System.out.print(charsGeneratePassword[c]);
//                            System.out.print(charsGeneratePassword[d]);
                        randomPasswordList.add(charsGeneratePassword[a] + charsGeneratePassword[b] + charsGeneratePassword[c] + charsGeneratePassword[d]);
//                            System.out.println();
                    }
                }
            }
        }

        int guess;
        int c = 0;

        for(int y = 0; y < 3; y++) {
            int randomPassword = r.nextInt(10000);
            String password = randomPasswordList.get(randomPassword);
//            String password = "ABAB"; Test for controled Test Password//
            guess = 0;
            for (int x = 0; x <= randomPasswordList.size(); x++) {

                int lookForRandomPassword = x;
                String pw = randomPasswordList.get(lookForRandomPassword);

                if (password.equals(pw)) {
                    System.out.println("Pasword: " + password);
                    System.out.println("Found it: " + password + " == " + pw);
                    System.out.println("Took " + guess + " guesses\n");
                    x = randomPasswordList.size() + 1;
                }
                guess++;
            }
            c = guess + c;
        }
        System.out.println("On average took " + (c/3) + " guesses each time.");

    }
}
