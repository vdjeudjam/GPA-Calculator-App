package gpa.calculator;

public class Subject
{
    protected String grade;
    protected double creditValue;
    protected double gradePoint;

    
    public Subject(){
        grade = "";
        creditValue = 0;
        gradePoint = 0;
    }
    
    public Subject(String g, double ch){
    	grade = g;
    	creditValue = ch;
    }
    
    public void setGrade(String g){
    	grade = g;
    }
    
    public void setcreditValue(double ch){
    	creditValue = ch;
    }
    
    public void setGradePoint(){
        if (grade.equals("A")){
            gradePoint = 4.00;
        }
        else if (grade.equals("B+")){
            gradePoint = 3.5;
        }
        else if (grade.equals("B")){
            gradePoint = 3;
        }
        else if (grade.equals("C+")){
            gradePoint = 2.5;
        }
        else if (grade.equals("C")){
            gradePoint = 2;
        }
        else if (grade.equals("D+")){
            gradePoint = 1.5;
        }
        else if (grade.equals("D")){
            gradePoint = 1;
        }
        else if (grade.equals("F")){
            gradePoint = 0.0;
        }
    }
    
    public String getGrade(){
        return grade;
    }
        
    public double getcreditValue(){
        return creditValue;
    }
    
    public double getGradePoint(){
        return gradePoint;
    }  
}
