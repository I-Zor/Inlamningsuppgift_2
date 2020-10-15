import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistUtil {

   DateUtil du = new DateUtil();
   ListUtil lu = new ListUtil();
   String writeToFile = "trainingOccasions.txt";
   String readFromFile = "src/customers.txt";


   public String isLookingForMembers(String input) {
      List<Person> personList = lu.readDataFromOriginalFile(readFromFile);
      LocalDate lt = LocalDate.now();
      String response = "blabla";
      for (Person p : personList) {
         if ((p.name.equalsIgnoreCase(input) || p.pn.equals(input)) &&
                 du.isDurationShorterThanYear(p.dateOfAnnualFee, lt)) {
            response = p.name + " är nuvarande medlem";
            TrainingOccasion to = new TrainingOccasion(p.pn, p.name, lt);
            lu.writeDataToTrainersFile(writeToFile, to);
         }
         else if ((p.name.equalsIgnoreCase(input) || p.pn.equals(input)) &&
                 !du.isDurationShorterThanYear(p.dateOfAnnualFee, lt))
            response = p.name + " är förre detta medlem";
         else
            response = input + " är obehörig";
      }
      return response;
   }
}
