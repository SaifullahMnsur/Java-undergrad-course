public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase1 = new StudentDatabase();
        // Operations in student detabase 1
        System.out.println("DATABASE 1:");
        studentDatabase1.displayAllStudents();

        Student student1 = new Student("9876543210", "SAYFULLAH MONSUR");
        student1.addGrade(3.5);
        student1.addGrade(3.75);
        student1.addGrade(3.25);
        student1.addGrade(3.5);
        studentDatabase1.addStudent(student1);

        Student student2 = new Student("5432109876", "SMSS");
        student2.addGrade(3.5, 3.25, 4.0, 3.75);
        studentDatabase1.addStudent(student2);
        studentDatabase1.addStudent(new Student("1234567890", "MNSR SFLLH", 3.25, 4.0, 3.25, 3.0, 3.5));

        studentDatabase1.displayAllStudents();
        studentDatabase1.displayStudentByID("9876543210");
        studentDatabase1.displayStudentByID("9876543201");

        
        System.out.println("\nDATABASE 2:");
        // Operations in student database 2
        StudentDatabase studentDatabase2 = new StudentDatabase(new Student("9876543210", "SAYFULLAH MONSUR", 3.5, 3.75, 3.25, 3.5),
                                                               new Student("5432109876", "SMSS", 3.5, 3.25, 4.0, 3.75),
                                                               new Student("1234567890", "MNSR SFLLH", 3.25, 4.0, 3.25, 3.0, 3.5));
        studentDatabase2.displayAllStudents();
    }
}