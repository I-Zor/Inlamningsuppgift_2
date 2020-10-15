import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String originalFile = "src/customers.txt";
        ListUtil lu = new ListUtil();
        lu.readDataFromOriginalFile(originalFile);

        Scanner sc = new Scanner(System.in);
        Mode m = new Mode();
        int respons = 0;

        while (true) {
            System.out.println("Välj arbetssätt (skriv 1 eller 2)" +
                    "\n1 - receptionist\n2 - personliga tränare");
            try {
                respons = sc.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Felaktig inmatning. Försök igen.");
                sc.nextLine();
            }
            if (respons == 1 || respons == 2)
            m.isChoosingMode(respons);
            break;
        }
    }
}
