import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String originalFile = "src/customers.txt";
        ListUtil lu = new ListUtil();
        ReceptionistUtil ru = new ReceptionistUtil();
        TrainerUtil tu = new TrainerUtil();
        lu.readCustomersFile(originalFile);

        Scanner sc = new Scanner(System.in);
        int respons = 0;
        boolean right = true;

        while (right) {
            System.out.println("Välj arbetssätt (skriv 1 eller 2)" +
                    "\n1 - receptionist\n2 - personliga tränare");
            try {
                respons = sc.nextInt();
                right = false;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Felaktig inmatning. Försök igen.");
                sc.nextLine();
            }
            if (respons == 1) {
                Scanner s = new Scanner(System.in);
                System.out.println("Ange namn eller personnummer:");
                String input = s.nextLine();
                System.out.println(ru.isLookingForMembers(input));
            } else if (respons == 2) {
                Scanner x = new Scanner(System.in);
                System.out.println("Ange namn eller personnummer:");
                String input = x.nextLine();
                System.out.println(tu.isLookingForTrainingOccasion(input));
            }
        }
    }
}

