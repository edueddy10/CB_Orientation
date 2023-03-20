public class CleanThis {
    public static void main(String[] args) {

        int age = 1 ;
        boolean withAdult = true;
        boolean vip = true;

        if (age >= 18 && (!vip)) {
            System.out.println("Grünes Band");
        } else if (age >= 18 && (vip))
            System.out.println("Grünes Band \nGoldenes Band dazu!");

        if (age >= 16 && age < 18 && (!vip)) {
            System.out.println("Gelbes Band");
        } else if (age >= 16 && age < 18 && (vip))
            System.out.println("Gelbes Band \nGoldenes Band dazu!");

        if (age > 3 && age <= 15 && (withAdult) && (!vip)) {
            System.out.println("Rotes Band");
        } if (age > 3 && age <= 15 && (withAdult) && (vip)) {
            System.out.println("Rotes Band \nGoldenes Band dazu!");
        } else if (age > 3 && age <= 15 && (!withAdult) || age <= 3)
            System.out.println("Kein Zutritt");
    }
}



