import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> studentNames = new ArrayList<>();
        List<List<Integer>> studentScores = new ArrayList<>();

        System.out.println("Enter the number of students:");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline not consumed by nextInt()

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter the name of student " + (i + 1) + ":");
            String studentName = scanner.nextLine();
            studentNames.add(studentName);

            System.out.println("Enter the number of subjects for student " + (i + 1) + ":");
            int numSubjects = scanner.nextInt();
            scanner.nextLine(); // consume newline not consumed by nextInt()

            List<Integer> scores = new ArrayList<>();
            for (int j = 0; j < numSubjects; j++) {
                System.out.println("Enter the grade of student " + (i + 1) + " for subject " + (j + 1) + ":");
                int score = scanner.nextInt();
                scores.add(score);
            }
            studentScores.add(scores);
        }

        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println("\nStudent: " + studentNames.get(i));
            List<Integer> scores = studentScores.get(i);
            System.out.println("Average: " + calculateAverage(scores));
            System.out.println("Highest: " + calculateHighest(scores));
            System.out.println("Lowest: " + calculateLowest(scores));
        }
    }

    private static double calculateAverage(List<Integer> scores) {
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    private static int calculateHighest(List<Integer> scores) {
        int highest = scores.get(0);
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }

    private static int calculateLowest(List<Integer> scores) {
        int lowest = scores.get(0);
        for (int score : scores) {
            if (score < lowest) {
                lowest = score;
            }
        }
        return lowest;
    }
}
