import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilTest {

    ListUtil lu = new ListUtil();


    @Test
    public void readDataFromOriginalFileTest() {
        String readFromFile = "test/customersTest.txt";
        List<Person> personList = lu.readDataFromOriginalFile(readFromFile);
        assertEquals(personList.size(), 2);
    }

    @Test
    public void readDataFromTrainersFileTest() {
        String file = "test/trainingOccasionsTest.txt";
        String date = "2020-10-10";
        LocalDate dateOfTraining = LocalDate.parse(date);
        TrainingOccasion to = new TrainingOccasion("7603021234", "Alhambra Aromes", dateOfTraining);
        lu.writeDataToTrainersFile(file, to);
        List<TrainingOccasion> trainingOccasionList = lu.readDataFromTrainersFile(file);
        assertEquals(trainingOccasionList.size(), 1);
    }
}