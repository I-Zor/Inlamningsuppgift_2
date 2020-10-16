import java.util.ArrayList;
import java.util.List;

public class TrainerUtil {

    ListUtil lu = new ListUtil();

    public String isLookingForTrainingOccasion(String input) {
        List<TrainingOccasion> trainingOccasionList =
                lu.readTrainingOccasionsFile("src/trainingOccasions.txt");
            String result = "";
            for (TrainingOccasion to : trainingOccasionList) {
                if (to.getPn().equals(input) || to.getName().equalsIgnoreCase(input)) {
                    result = to.pn + " " + to.name + " " + to.dateOfTraining;
                    return result;
                }
            }

        return "Det finns inte data om den personen hittils";
    }
}
