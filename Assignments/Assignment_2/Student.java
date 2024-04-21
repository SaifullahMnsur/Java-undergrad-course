import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Student {
    private String ID, name;
    private ArrayList<Double> gradeList;
    private double GPA;

    // constructors
    public Student(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.gradeList = new ArrayList<>();
        this.GPA = 0.0;
    }
    public Student(String ID, String name, ArrayList<Double> gradeList){
        this.ID = ID;
        this.name = name;
        this.gradeList = gradeList;
        this.GPA = calculateAverageGrade(); 
    }
    public Student(String ID, String name, Double... grades){
        this.ID = ID;
        this.name = name;
        gradeList = new ArrayList<>();
        Collections.addAll(this.gradeList, grades);
        this.GPA = calculateAverageGrade(); 
    }

    // methods
    public double calculateAverageGrade(){
        double gradeSum = 0;
        for( double grade : gradeList ){
            gradeSum += grade;
        }
        GPA = gradeSum/gradeList.size();
        return GPA;
    }
    public void addGrade(double grade){
        double prevGradeSum = GPA*gradeList.size();
        gradeList.add(grade);
        GPA = (prevGradeSum + grade) / gradeList.size(); // caluculating average grade point with each grade added to Student's profile
    }
    public void addGrade(Double... grades){
        double prevGradeSum = GPA*gradeList.size();
        Collections.addAll(this.gradeList,grades);
        double gradeSum = Arrays.stream(grades).mapToDouble(Double::doubleValue).sum();
        GPA = (prevGradeSum + gradeSum) / gradeList.size(); // caluculating average grade point with each grade added to Student's profile
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
    public double getGPA(){
        return GPA;
    }
}
