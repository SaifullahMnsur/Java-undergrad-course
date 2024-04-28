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
    
    public void printAllStudents(){
        System.out.println();
        if( studentList.isEmpty() ){
            System.out.println("NO STUDENTS FOUND IN THE DATABASE\n");
            return;
        } else {
            System.out.println("SHOWING ALL STUDENTS' INFORMATIONS\n" );
        }
        for( Student student : studentList ){
            student.printInfo();
        }
    }

    public void printStudentByID(String ID){
        for (Student student : studentList) {
            if( ID.equals(student.getID())){
                System.out.println("\nSTUDENT FOUND!");
                student.printInfo();
                System.out.println();
                return;
            }
        }
        System.out.println("STUDENT NOT FOUND WITH ID: " + ID + "!\n");
    }
}
