public class Student2 extends Student {
    private double finalGrade;

    public Student2() {
        super();
        this.finalGrade = 0.0;
    }

    public Student2(String name, int age) {
        super(name, age, "Not yet added");
        this.finalGrade = 0.0;
    }

    public double calculateFinalGrade(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        this.finalGrade = (double)totalMarks / (double)marks.length;
        return this.finalGrade;
    }

    public static boolean checkPassStatus(double finalGrade) {
        return finalGrade >= 50.0;
    }

    // Sends a string while converting the object to string
    // or Sends a string while printing the object from inside any print method
    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + 
               "Age: " + this.age + "\n" +
               "Final Grade: " + this.finalGrade + "\n" +
               "Status: " + (Student2.checkPassStatus(this.finalGrade) ? "Passed" : "Failed");
    }


    public static void main(String[] args) {
        String name = "Saifullah";
        int age = 22;

        int[] marks = {50, 10, 60, 46};
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\n");

        // Using non-parameterized constructor
        System.out.println("=".repeat(50));
        System.out.println("Non-parameterized Example:");
        System.out.println("-".repeat(50));
        
        Student2 student = new Student2();
        System.out.println("Student object created!");
        student.setName(name);
        student.setAge(age);
        student.calculateFinalGrade(marks);
        System.out.println("Updated all the attrebutes!");
        
        System.out.println("-".repeat(50));
        System.out.println("Student's Information:");
        System.out.println(student); // prints the information sent from toString() method
        System.out.println("=".repeat(50));

        // Using parameterized constructor
        System.out.println("=".repeat(50));
        System.out.println("Parameterized Example:");
        System.out.println("-".repeat(50));
        
        Student2 student2 = new Student2(name, age);
        student2.calculateFinalGrade(marks);
        System.out.println("Student object created with initializing all parameters!");

        System.out.println("-".repeat(50));
        System.out.println("Student's Information:");
        System.out.println(student2); // prints the information sent from toString() method
        System.out.println("=".repeat(50));
    }
}
