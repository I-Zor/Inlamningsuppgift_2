import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListUtil {

    public List<Person> readDataFromOriginalFile(String readFromFile) {

        String firstLine;
        String personsDataSecondLine = "";
        Path inFile;
        List<Person> personList = new ArrayList<>();

        String[] personsDataFirstLine;
        inFile = Paths.get(readFromFile);

        try (Scanner sc = new Scanner(inFile)) {

            while (sc.hasNext()) {
                firstLine = sc.nextLine();
                personsDataFirstLine = firstLine.split(",");
                sc.nextLine();
                if (sc.hasNext()) {
                    personsDataSecondLine = sc.nextLine();
                    sc.nextLine();
                }

                Person p = new Person(personsDataFirstLine[0].trim(), personsDataFirstLine[1].trim(),
                        personsDataSecondLine.trim());

                personList.add(p);
            }
        } catch (IOException e) {
            System.out.println("Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        }
        return personList;
    }

    public void writeDataToTrainersFile(String writeToFile, TrainingOccasion to) {
        Path outFile = Paths.get(writeToFile);
        try (PrintWriter w = new PrintWriter(
                Files.newBufferedWriter(outFile, StandardOpenOption.APPEND))) {
            w.print(to.pn + ", " + to.name + ", " + to.dateOfTraining);
        } catch (FileNotFoundException e) {
            System.out.println("Filen kunde inte hittas");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Det gick inte att skriva till fil");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public List<TrainingOccasion> readDataFromTrainersFile(String readFromFile) {

        String input;
        String[] trainingOccasionData;
        Path inFile;
        List<TrainingOccasion> trainingOccasionList = new ArrayList<>();

        inFile = Paths.get(readFromFile);

        try (Scanner sc = new Scanner(inFile)) {

            while (sc.hasNext()) {
                input = sc.nextLine();
                trainingOccasionData = input.split(",");

                TrainingOccasion x = new TrainingOccasion(trainingOccasionData[0], trainingOccasionData[1],
                        LocalDate.parse(trainingOccasionData[2]));

                trainingOccasionList.add(x);
            }
        } catch (IOException e) {
            System.out.println("Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        }
        return trainingOccasionList;
    }
}
