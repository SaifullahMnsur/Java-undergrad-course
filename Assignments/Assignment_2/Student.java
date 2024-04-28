import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Student {
    private String ID, name;
    private ArrayList<Double> gradeList;
    private double gpa;

    // constructors
    public Student(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.gradeList = new ArrayList<>();
        this.gpa = 0.0;
    }

    public Student(String ID, String name, ArrayList<Double> gradeList){
        this.ID = ID;
        this.name = name;
        this.gradeList = gradeList;
        this.gpa = calculateAverageGrade(); 
    }

    public Student(String ID, String name, Double... grades){
        this.ID = ID;
        this.name = name;
        gradeList = new ArrayList<>();
        Collections.addAll(this.gradeList, grades);
        this.gpa = calculateAverageGrade(); 
    }

    // methods
    public double calculateAverageGrade(){
        double gradeSum = 0;
        for( double grade : gradeList ){
            gradeSum += grade;
        }
        gpa = gradeSum/gradeList.size();
        return gpa;
    }

    public void addGrade(double grade){
        double prevGradeSum = gpa*gradeList.size();
        gradeList.add(grade);
        gpa = (prevGradeSum + grade) / gradeList.size(); // caluculating average grade point with each grade added to Student's profile
    }

    public void addGrade(Double... grades){
        double prevGradeSum = gpa*gradeList.size();
        Collections.addAll(this.gradeList,grades);
        double gradeSum = Arrays.stream(grades).mapToDouble(Double::doubleValue).sum();
        gpa = (prevGradeSum + gradeSum) / gradeList.size(); // caluculating average grade point with each grade added to Student's profile
    }

    private void printGrade(ArrayList<Double> grades){
        System.out.print("Grades: ");
        for (Double grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }

    public void printInfo(){
            System.out.println("ID: " + this.getID());
            System.out.println("Name: " + this.getName());
            this.printGrade(this.getGrades());
            System.out.println("GPA: " + this.getGpa() + "\n");
    }

    // setGrades method overloading
    public void setGrades(ArrayList<Double> gradeList){
        this.gradeList = gradeList;
        this.calculateAverageGrade(); // updating average grade with new grades list
    }

    public void setGrades(Double...grades){
        Collections.addAll(this.gradeList,grades);
        this.calculateAverageGrade();
    }

    // getter methods
    public String getName(){
        return name;
    }

    public String getID(){
        return ID;
    }

    public ArrayList<Double> getGrades(){
        return gradeList;
    }
    
    public double getGpa(){
        return gpa;
    }
}
