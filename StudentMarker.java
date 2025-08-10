import java.util.ArrayList;
import java.util.Scanner;
// Class to store student marks and calculate
class Mark {
    String name;
    int[] scores;   // marks array
    double average;
    int highest;
    int lowest;

    // Constructor
    Mark(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
        calculate();
    }

    // Method to calculate average, highest, and lowest
    private void calculate() {
        int sum = 0;
        highest = scores[0];
        lowest = scores[0];

        for (int score : scores) {
            sum += score;
            if (score > highest) 
            {
                highest = score;
            }
            if (score < lowest) 
            {
            lowest = score;
            }
        }

        average = (double) sum / scores.length;
    }

    // Method to display student data
    void display() {
        System.out.println(name + "\t" + average + "\t" + highest + "\t" + lowest);
    }
}

// Main program
public class StudentMarker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mark> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Summary Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter number of subjects: ");
                    int n = sc.nextInt();

                    int[] scores = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter score for Subject " + (i + 1) + ": ");
                        scores[i] = sc.nextInt();
                    }

                    students.add(new Mark(name, scores));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student data available.");
                    } else {
                        System.out.println("Name\tAverage\tHighest\tLowest");
                        System.out.println("----------------------------------");
                        for (Mark s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}