/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import info5100.university.example.College.College;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Department.DepartmentAccount;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    public static Random random;

    /**
     * @param args the command line arguments
     */

    public static void populateEmployers(Department dept) {
        String[] employers = {"Google", "Amazon", "Facebook", "Apple", "Microsoft", "Oracle"};
        for (String e : employers) {
            dept.addEmployer(e);
        }
    }

    public static void populatePeople(Department dept) {
        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Person p = dept.addPerson("Person" + String.valueOf(dept.toString().hashCode() + 1));
            dept.addEmployer("Employer "+String.valueOf(dept.toString().hashCode() + 1));
            people.add(p);
        }
        for (int i = 0; i < 10; i++) {
            dept.addStudent(people.remove(random.nextInt(people.size())));
            dept.addFaculty(people.remove(random.nextInt(people.size())));
        }


    }

    public static void populateCourse(Department dept, String[] courses) {
        ArrayList<Course> courseList = new ArrayList<>();
        for (String course : courses) {
            Course c = dept.newCourse(course, String.valueOf(random.nextInt(200000) + 300000), random.nextInt(2) + 3);
            courseList.add(c);
        }

        dept.addCoreCourse(courseList.get(0));

        int rand = random.nextInt(4) + 1;
        for(int i=rand; i <= rand+5; i++){
            dept.addElectiveCourse(courseList.get(i));
        }

    }
    

    public static void main(String[] args) {
        // TODO code application logic here
        random  = new Random();

        College college = new College("College of Engineering");

        String[] departmentNames = {"Computer Science", "Information Systems", "Software Engineering Systems"};
        String[] degreeNames = {"MS CS", "MS IS", "MS SES"};
        String[][] courses = {{"CS5001", "CS5002", "CS5003", "CS5004", "CS5005", "CS5006", "CS5007", "CS5008", "CS5009", "CS5010"},
                            {"IS5001", "IS5002", "IS5003", "IS5004", "IS5005", "IS5006", "IS5007", "IS5008", "IS5009", "IS5010"},
                            {"SES5001", "SES5002", "SES5003", "SES5004", "SES5005", "SES5006", "SES5007", "SES5008", "SES5009", "SES5010"}};

        for (int i = 0; i < departmentNames.length; i++) {
            Department department = new Department(departmentNames[i], degreeNames[i]);
            college.addDepartment(department);
            college.addDepartmentAccount(new DepartmentAccount(department));
            populateCourse(department, courses[i]);
            populatePeople(department);
            populateEmployers(department);


        }

    
    }

}
