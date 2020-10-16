import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilTest {

    ListUtil lu = new ListUtil();


    @Test
    public void readDataFromOriginalFileTest() {
        String readFromFile = "test/customersTest.txt";
        List<Person> personList = lu.readCustomersFile(readFromFile);
        assertEquals(personList.size(), 2);
        assertNotEquals(personList.size(), 4);
    }

    @Test
    public void readDataFromTrainersFileTest() {
        String file = "test/trainingOccasionsTest.txt";
        String date = "2020-10-10";
        LocalDate dateOfTraining = LocalDate.parse(date);
        TrainingOccasion t = new TrainingOccasion("7603021234", "Alhambra Aromes", dateOfTraining);
        lu.writeDataToTrainersFile(file, t);
        List<TrainingOccasion> trainingOccasionList = lu.readTrainingOccasionsFile(file);
        assertEquals(trainingOccasionList.size(), 1);
        assertNotEquals(trainingOccasionList.size(), 2);
    }
}