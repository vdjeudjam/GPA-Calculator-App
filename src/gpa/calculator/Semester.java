package gpa.calculator;

public class Semester extends Subject
{
    protected double gpa;
    protected double totalGradePoint;
    protected double totalcreditValue;
    
    public Semester(){
        gpa = 0;
        totalGradePoint = 0;
        totalcreditValue = 0;
    }
    
    public Semester(String g, double ch){
        super(g,ch);
    }
   
    public void setcreditValue(double ch){
    	creditValue = ch;
    }
    
    public void setGrade(String g){
    	grade = g;
    }
    
    public void calcTotalGradePoint(){
        super.setGradePoint();
       
        double sumOfGradePoint = creditValue * gradePoint;
        totalGradePoint = totalGradePoint + sumOfGradePoint;
    }
    
    public void calcTotalcreditValue(){
        totalcreditValue = totalcreditValue + creditValue;
    }
    
    public void calculateGpa(){
        gpa = totalGradePoint / totalcreditValue;
    }
    
    public double getGpa(){
        return gpa;
    }
    
}
