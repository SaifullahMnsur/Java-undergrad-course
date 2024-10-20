public class Student {
    protected String name, grade;
    protected int age;

    public Student(){
        this.name = "Not Yet Added!";
        this.age = -1;
        this.grade = "Not Yet Added!";
    }
    
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    
    // setters method
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // getters method
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGrade() {
        return grade;
    }

    // Sends a string while converting the object to string
    // or Sends a string while printing the object from inside any print method
    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + 
               "Age: " + this.age + "\n" +
               "Grade: " + this.grade;
    }


    // Static main method to test instance of this class
    public static void main(String[] args) {
        String name = "Saifullah";
        int age = 22;
        String grade = "A";

        // Using non-parameterized constructor
        System.out.println("=".repeat(50));
        System.out.println("Non-parameterized Example:");
        System.out.println("-".repeat(50));
        
        Student student1 = new Student();
        System.out.println("Student object created!");
        student1.setName(name);
        student1.setAge(age);
        student1.setGrade(grade);
        System.out.println("Updated all the attrebutes!");
        
        System.out.println("-".repeat(50));
        System.out.println("Student's Information:");
        System.out.println(student1); // prints the information sent from toString() method
        System.out.println("=".repeat(50));

        // Using parameterized constructor
        System.out.println("=".repeat(50));
        System.out.println("Parameterized Example:");
        System.out.println("-".repeat(50));
        
        Student student2 = new Student(name, age, grade);
        System.out.println("Student object created with initializing all parameters!");

        System.out.println("-".repeat(50));
        System.out.println("Student's Information:");
        System.out.println(student2); // prints the information sent from toString() method
        System.out.println("=".repeat(50));
    }
}