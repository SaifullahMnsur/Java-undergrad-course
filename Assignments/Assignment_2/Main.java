import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase1 = new StudentDatabase();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add new student");
            System.out.println("2. Search student by ID");
            System.out.println("3. Show all student");
            System.out.println("4. Exit");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {   
                case 1:
                    Student newStudent = createStudent(sc);
                    studentDatabase1.addStudent(newStudent);
                    break;
                case 2:
                    showById(studentDatabase1, sc);
                    break;
                case 3:
                    showAll(studentDatabase1);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Incorrect input! try again!");
                    break;
            }
        } while (choice != 4);


        sc.close();
    }

    private static void showAll(StudentDatabase studentDatabase) {
        studentDatabase.printAllStudents();
    }

    private static void showById(StudentDatabase studentDatabase, Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.next();
        sc.nextLine();
        studentDatabase.printStudentByID(id);
    }

    private static Student createStudent(Scanner sc) {
        System.out.print("Enter Student id: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter grades with decimal points (Separated by spaces): ");
        ArrayList<Double> grades = new ArrayList<>();
        
        String gradeString = sc.nextLine();
        Scanner gradeScanner = new Scanner(gradeString);
        while (gradeScanner.hasNextDouble()) {
            double grade = gradeScanner.nextDouble();
            grades.add(grade);
        }
        gradeScanner.close();

        Student student = new Student(id, name, grades);
        System.out.println("Done!");
        return student;
    }
}