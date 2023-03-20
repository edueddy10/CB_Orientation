public class CleanThis_2 {
    public static void main(String[] args) {

        int age = 14;
        boolean withAdult = true;
        boolean vip = true;
        boolean entrance = true;

        if (age >= 18) {
            System.out.println("Grünes Band");

        } else if (age >= 16) {
            System.out.println("Gelbes Band");

        } else if (age > 3 && age <= 15 && (withAdult)) {
            System.out.println("Rotes Band");

        } else {
            System.out.println("Kein Zutritt");
            entrance = false;
        }
        if(vip && entrance) {
            System.out.println("Goldenes Band dazu!");
        }
    }
}


