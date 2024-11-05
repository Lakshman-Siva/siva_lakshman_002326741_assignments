/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import info5100.university.example.College.College;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Department.DepartmentAccount;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Faculty.FacultyProfile;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    public static Random random;

    /**
     * @param args the command line arguments
     */

    /**
     * Populates course loads for all students in a department across multiple semesters
     * Assigns 3 random courses per semester to each student
     */
    public static void populateCourseLoad(Department dept) {
        ArrayList<StudentProfile> sd = dept.getStudentDirectory().getStudentList();
        ArrayList<Course> courses = dept.getCourseCatalog().getCourseList();
        String semesters[] = {"Fall 2024", "Spring 2025", "Fall 2025"};

        for (StudentProfile sp : sd) {
            for (String sem : semesters) {
                sp.newCourseLoad(sem);
                Set<Integer> usedCourses = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    Integer courseCount = random.nextInt(courses.size());
                    while (usedCourses.contains(courseCount)) {
                        courseCount = random.nextInt(courses.size());
                    }

                    dept.RegisterForAClass(sp.getStudentId(), courses.get(courseCount).getCOurseNumber(), sem);
                    usedCourses.add(courseCount);
                }
            }
        }
    }

    /**
     * Creates course schedules for multiple semesters
     * Assigns random faculty to courses and generates seats
     */
    public static void populateCourseSchedule(Department dept) {
        String semesters[] = {"Fall 2024", "Spring 2025", "Fall 2025"};
        ArrayList<Course> courses = dept.getCourseCatalog().getCourseList();
        ArrayList<FacultyProfile> faculty = dept.getFacultyDirectory().getTeacherList();

        for (String s : semesters) {
            CourseSchedule cs = dept.newCourseSchedule(s);

            for (Course c : courses) {
                CourseOffer co = cs.newCourseOffer(c.getCOurseNumber());
                FacultyProfile fp = faculty.get(random.nextInt(faculty.size()));
                co.AssignAsTeacher(fp);
                co.setFacultyRating(random.nextInt(5) + 1);
                co.generatSeats(15);
            }
        }
    }

    /**
     * Adds a predefined list of employers to the department
     */
    public static void populateEmployers(Department dept) {
        String[] employers = {"Google", "Amazon", "Facebook", "Apple", "Microsoft", "Oracle"};
        for (String e : employers) {
            dept.addEmployer(e);
        }
    }

    /**
     * Creates and assigns people as students and faculty in the department
     */
    public static void populatePeople(Department dept) {
        ArrayList<Person> people = new ArrayList<>();

        String[] names = {
            "Olivia", "Liam", "Emma", "Noah", "Ava", "Elijah", "Sophia", "James", 
            "Isabella", "Benjamin", "Mia", "Lucas", "Charlotte", "Henry", "Amelia", 
            "Alexander", "Harper", "Sebastian", "Evelyn", "Mason"
        };

        for (String s : names) {
            Person p = dept.addPerson(s);
            people.add(p);
        }
        for (int i = 0; i < 10; i++) {
            dept.addStudent(people.remove(random.nextInt(people.size())));
            dept.addFaculty(people.remove(random.nextInt(people.size())));
        }


    }

    /**
     * Creates courses and assigns them as core or elective courses in the department
     */
    public static void populateCourse(Department dept, String[] courses) {
        ArrayList<Course> courseList = new ArrayList<>();
        for (String course : courses) {
            Course c = dept.newCourse(course, String.valueOf(random.nextInt(200000) + 300000), random.nextInt(4) + 1);
            courseList.add(c);
        }

        dept.addCoreCourse(courseList.get(0));

        int rand = random.nextInt(4) + 1;
        for(int i=rand; i <= rand+5; i++){
            dept.addElectiveCourse(courseList.get(i));
        }
    }
    
    /**
     * Main method that initializes the university system and handles user interaction
     * Creates departments, populates data, and generates reports
     */
    public static void main(String[] args) {
        // TODO code application logic here
        random  = new Random();
        Scanner scanner = new Scanner(System.in);

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
            populateCourseSchedule(department);
            populateCourseLoad(department);
        }

        
        System.out.println("Data Population Completed");

        while(true) {
            System.out.println("\n*************************************************************");
            System.out.println("\nGenerate Report:");
            for(int i=1; i<=departmentNames.length; i++){
                System.out.println(i + ". " + departmentNames[i-1]);
            }
            System.out.println(departmentNames.length+1 + ". Exit");
            System.out.print("Enter the department number: ");
            int deptNum = scanner.nextInt();

            if(deptNum == departmentNames.length + 1){
                break;
            } else if (deptNum > departmentNames.length + 1 || deptNum < 0){
                System.out.println("Invalid department number.");
                continue;
            }
            Department department = college.getDepartments().get(deptNum-1);
            ArrayList<StudentProfile> students = department.getStudentDirectory().getStudentList();

            System.out.println("\nChoose the semester:");
            String semesters[] = {"Fall 2024", "Spring 2025", "Fall 2025"};
            
            for(int i=0; i<semesters.length; i++){
                System.out.println(i+1 + ". " + semesters[i]);
            }
            System.out.print("Enter the semester number: ");
            int semesterNum = scanner.nextInt();
            if(semesterNum > semesters.length || semesterNum < 0){
                System.out.println("Invalid semester number.");
                continue;
            }

            System.out.println("\n");
            System.out.println(semesters[semesterNum-1] + " Semester Report");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-20s %-20s %-20s %-10s %-10s %-15s\n",
            "Student Name", "Course Title", "Professor Name", "Grade", "GPA", "Tuition Fees");

            float avg_gpa = 0f;
            int total_tution_fees = 0, count = 0;

            for(StudentProfile student : students){
                String studentName = student.getStudentId();
                CourseLoad courseLoad = student.getTranscript().getCourseLoadBySemester(semesters[semesterNum-1]);
                ArrayList<SeatAssignment> seatassignments = courseLoad.getSeatAssignments();

                for(SeatAssignment sa : seatassignments) {
                    CourseOffer courseOffer = sa.getCourseOffer();
                    String course = courseOffer.getCourse().getCourseName();
                    String courseProfessor = courseOffer.getFacultyProfile().getName();
                    String gpa = "" + sa.getGPA();
                    String grade = sa.getGrade();
                    String fees = "$" + sa.getCreditHours()*1500;

                    avg_gpa += sa.getGPA();
                    total_tution_fees += sa.getCreditHours()*1500;
                    count++;

                    // Print the student's course information
                    System.out.printf("%-20s %-20s %-20s %-10s %-10s %-15s\n", studentName, course, courseProfessor, grade, gpa, fees);
                }
            }

            System.out.println("\nSummary:");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-40s %-20s\n", "Metric", "Value");

            // Print the summary values
            System.out.printf("%-40s %-20s\n", "Overall Average GPA for Semester", String.format("%.2f", avg_gpa/count));
            System.out.printf("%-40s %-20s\n", "Total Tuition Fees Paid", "$" + total_tution_fees);

        }
    }
}
