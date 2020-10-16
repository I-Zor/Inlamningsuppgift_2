import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListUtil {

    public List<Person> readCustomersFile(String readFromFile) {

        String firstLine;
        String personsDataSecondLine = "";
        Path inFile;
        List<Person> personList = new ArrayList<>();

        String personsDataFirstLine_pn;
        String personsDataFirstLine_name;
        inFile = Paths.get(readFromFile);

        try (Scanner sc = new Scanner(inFile)) {

            while (sc.hasNext()) {
                firstLine = sc.nextLine();
                personsDataFirstLine_pn = firstLine.substring(0, 10);
                personsDataFirstLine_name = firstLine.substring(12);

                if (sc.hasNext()) {
                    personsDataSecondLine = sc.nextLine();
                }

                Person p = new Person(personsDataFirstLine_pn.trim(), personsDataFirstLine_name.trim(),
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
        try (BufferedWriter w = new BufferedWriter(new PrintWriter(new FileWriter(new File(writeToFile), true))))
                //(BufferedWriter w = new BufferedWriter(new PrintWriter(new FileWriter(new File("MembersTrained.txt"),true))))
               // Files.newBufferedWriter(outFile, StandardOpenOption.APPEND)))
        {
            w.write(to.name + ", " + to.pn + "\n" + to.getDateOfTraining() + "\n");
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

    public List<TrainingOccasion> readTrainingOccasionsFile(String readFromFile) {

        String input;
        String trainingOccasionFirstLine_name;
        String trainingOccasionFirstLine_pn;
        String trainingOccasionSecondLine = "";
        Path inFile;
        List<TrainingOccasion> trainingOccasionList = new ArrayList<>();

        inFile = Paths.get(readFromFile);

        try (Scanner sc = new Scanner(inFile)) {
            while (sc.hasNext()) {
                input = sc.nextLine();
                trainingOccasionFirstLine_pn = input.substring(0, 10);
                trainingOccasionFirstLine_name = input.substring(12);
                if (sc.hasNext()) {
                    trainingOccasionSecondLine = sc.nextLine();
                }

                TrainingOccasion x = new TrainingOccasion(trainingOccasionFirstLine_pn.trim(),
                        trainingOccasionFirstLine_name.trim(),
                        LocalDate.parse(trainingOccasionSecondLine));

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
