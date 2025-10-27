/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Academic;
import business.Profiles.StudentProfile;
/**
 *
 * @author krishi
 */
public class Enrollment {
    private static int enrollmentIdCounter = 5000;
    
    private String enrollmentId;
    private StudentProfile student;
    private CourseOffering courseOffering;
    private String enrollmentDate;
    private String status; // ACTIVE, DROPPED, COMPLETED
    private String grade; // A, B, C, D, F, or null if not graded
    
    public Enrollment(StudentProfile student, CourseOffering courseOffering) {
        this.enrollmentId = "ENR" + (enrollmentIdCounter++);
        this.student = student;
        this.courseOffering = courseOffering;
        this.status = "ACTIVE";
        this.enrollmentDate = java.time.LocalDate.now().toString();
    }
    
    public String getEnrollmentId() {
        return enrollmentId;
    }
    
    public StudentProfile getStudent() {
        return student;
    }
    
    public void setStudent(StudentProfile student) {
        this.student = student;
    }
    
    public CourseOffering getCourseOffering() {
        return courseOffering;
    }
    
    public void setCourseOffering(CourseOffering courseOffering) {
        this.courseOffering = courseOffering;
    }
    
    public String getEnrollmentDate() {
        return enrollmentDate;
    }
    
    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public void drop() {
        this.status = "DROPPED";
        courseOffering.decrementEnrolled();
    }
}
