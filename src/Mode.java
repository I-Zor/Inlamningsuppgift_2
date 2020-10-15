import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ivona Zoricic
 * Date: 2020-10-15
 * Time: 13:56
 * Project: Inlämningsuppgift_2
 * Copywrite: MIT
 */
public class Mode {

    Scanner sc = new Scanner(System.in);
    ReceptionistUtil ru = new ReceptionistUtil();
    TrainerUtil tu = new TrainerUtil();

    public void receptionistMode() {
        System.out.println("Ange namn eller personnummer:");
        String input = sc.next();
        System.out.println(ru.isLookingForMembers(input));
    }

    public void trainerMode() {
        System.out.println("Ange namn eller personnummer:");
        String input = sc.next();
        System.out.println(tu.isLookingForTrainingOccasion(input));
    }

    public void isChoosingMode(int mode) {
        if (mode == 1)
            receptionistMode();
        else if (mode == 2)
            trainerMode();
        else
            System.out.println("Fel nummer. Skriv 1 eller 2");
    }
}
