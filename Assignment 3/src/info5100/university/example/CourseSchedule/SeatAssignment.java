/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import java.util.Random;

import info5100.university.example.CourseCatalog.Course;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {
    float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    Seat seat;
    boolean like; //true means like and false means not like
    Random random;
    CourseLoad courseload;
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
        random = new Random();
        like = random.nextBoolean();
        grade = 3.0f + random.nextFloat();        
        grade = Math.round(grade * 10) / 10.0f;
    }

    public float getGPA(){
        return grade;
    }

    public boolean getLike(){
        return like;
    }
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    public int getCreditHours(){
        return seat.getCourseCredits();
    }
    public Seat getSeat(){
        return seat;
    }
    public CourseOffer getCourseOffer(){
        
        return seat.getCourseOffer();
    }
    public Course getAssociatedCourse(){
        
        return getCourseOffer().getSubjectCourse();
    }
    public float GetCourseStudentScore(){
        return getCreditHours()*grade;
    }
    
    public String getGrade() {
        if (grade == 4.0f) {
            return "A";
        } else if (grade >= 3.7f) {
            return "A-";
        } else if (grade >= 3.3f) {
            return "B+";
        } else if (grade >= 3.0f) {
            return "B";
        }
        return "F";
    }
}
