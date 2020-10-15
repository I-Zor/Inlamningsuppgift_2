import java.util.ArrayList;
import java.util.List;

public class TrainerUtil {

    public String isLookingForTrainingOccasion(String input){
        List<TrainingOccasion> trainingOccasionList = new ArrayList<>();
        String result = "";
        for (TrainingOccasion to : trainingOccasionList){
            if (to.name.equalsIgnoreCase(input) || to.pn.equals(input))
                result = to.name + to.dateOfTraining;
        }
        return result;
    }
}
