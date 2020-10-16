import java.time.LocalDate;
import java.util.List;

public class ReceptionistUtil {

    DateUtil du = new DateUtil();
    ListUtil lu = new ListUtil();
    String writeToFile = "src/trainingOccasions.txt";
    String readFromFile = "src/customers.txt";

    public String isLookingForMembers(String input) {
        List<Person>personList = lu.readCustomersFile(readFromFile);
        LocalDate lt = LocalDate.now();
        String response = "";

        for (Person p : personList) {
            if (du.isDurationShorterThanYear(p.getDateOfAnnualFee()) && p.getName().equalsIgnoreCase(input) || p.getPn().equals(input)) {
                response = p.name + " är nuvarande medlem";
                TrainingOccasion to = new TrainingOccasion(p.pn, p.name, lt);
                lu.writeDataToTrainersFile(writeToFile, to);
                return response;
            } else if (p.getPn().equalsIgnoreCase(input) || p.getName().equals(input) ) {
                response = p.name + " är förre detta medlem";
                return response;
            }
        }
        return input + " är obehörig";
    }
}
