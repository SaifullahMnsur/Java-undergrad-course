import java.util.ArrayList;
import java.util.Collections;

public class StudentDatabase {
    private ArrayList<Student> studentList;
    // constructors
    public StudentDatabase() {
        this.studentList = new ArrayList<>();
    }
    public StudentDatabase(ArrayList<Student> studentList){
        this.studentList = studentList;
    }
    public StudentDatabase(Student... students){
        studentList = new ArrayList<>();
        Collections.addAll(studentList, students);
    }

    // methods
    public void addStudent(Student student){
        studentList.add(student);
    }

    private void displayGrades(ArrayList<Double> grades){
        System.out.print("Grades: ");
        for (Double grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }
    private void displayStudent(Student student){
            System.out.println("ID: " + student.getID());
            System.out.println("Name: " + student.getName());
            this.displayGrades(student.getGrades());
            System.out.println("GPA: " + student.getGPA() + "\n");
    }
    public void displayAllStudents(){
        System.out.println();
        if( studentList.isEmpty() ){
            System.out.println("NO STUDENTS FOUND IN THE DATABASE\n");
        } else {
            System.out.println("SHOWING ALL STUDENTS' INFORMATIONS\n" );
        }
        for( Student student : studentList ){
            displayStudent(student);
        }
        System.out.println();
    }
    public void displayStudentByID(String ID){
        for (Student student : studentList) {
            if( ID.equals(student.getID())){
                System.out.println("\nSTUDENT FOUND!");
                displayStudent(student);
                System.out.println();
                return;
            }
        }
        System.out.println("STUDENT NOT FOUND WITH ID: " + ID + "!\n");
    }
}
