import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrainingOccasion extends Person{

    protected Person person;
    protected LocalDate dateOfTraining;

    public TrainingOccasion(String pn, String name, LocalDate dateOfTraining){
        super(name, pn);
        dateOfTraining = LocalDate.now();
    }
}
