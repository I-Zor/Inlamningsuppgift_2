import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistUtil {

   DateUtil du = new DateUtil();
   ListUtil lu = new ListUtil();
   String writeToFile = "trainingOccasions.txt";


   public String isLookingForMembers(String indata) {
      List<Person> personList = new ArrayList<>();
      LocalDate lt = LocalDate.now();
      String response = "";
      for (Person p : personList) {
         if ((p.name.equalsIgnoreCase(indata) || p.pn.equals(indata)) &&
                 du.isDurationShorterThanYear(p.dateOfAnnualFee, lt)) {
            response = p.name + " är nuvarande medlem";
            TrainingOccasion to = new TrainingOccasion(p.pn, p.name, lt);
            lu.writeDataToTrainersFile(writeToFile, to);
         }
         else if ((p.name.equalsIgnoreCase(indata) || p.pn.equals(indata)) &&
                 !du.isDurationShorterThanYear(p.dateOfAnnualFee, lt))
            response = p.name + " är förre detta medlem";
         else
            response = indata + " är obehörig";
      }
      return response;
   }
}
