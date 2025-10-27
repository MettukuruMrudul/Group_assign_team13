/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Academic;
import business.Profiles.StudentProfile;
import java.util.ArrayList;
/**
 *
 * @author krishi
 */
public class EnrollmentDirectory {
    private ArrayList<Enrollment> enrollments;
    
    public EnrollmentDirectory() {
        this.enrollments = new ArrayList<>();
    }
    
    public Enrollment enrollStudent(StudentProfile student, CourseOffering offering) {
        // Check if student is already enrolled
        for (Enrollment e : enrollments) {
            if (e.getStudent().equals(student) && 
                e.getCourseOffering().equals(offering) && 
                e.getStatus().equals("ACTIVE")) {
                return null; // Already enrolled
            }
        }
        
        // Check if course has capacity
        if (!offering.hasAvailableSeats()) {
            return null; // Course is full
        }
        
        Enrollment enrollment = new Enrollment(student, offering);
        enrollments.add(enrollment);
        offering.incrementEnrolled();
        return enrollment;
    }
    
    public boolean dropEnrollment(String enrollmentId) {
        Enrollment enrollment = findEnrollment(enrollmentId);
        if (enrollment != null && enrollment.getStatus().equals("ACTIVE")) {
            enrollment.drop();
            return true;
        }
        return false;
    }
    
    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }
    
    public Enrollment findEnrollment(String enrollmentId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getEnrollmentId().equals(enrollmentId)) {
                return enrollment;
            }
        }
        return null;
    }
    
    public ArrayList<Enrollment> getEnrollmentsByStudent(StudentProfile student) {
        ArrayList<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student)) {
                studentEnrollments.add(enrollment);
            }
        }
        return studentEnrollments;
    }
    
    public ArrayList<Enrollment> getEnrollmentsByCourseOffering(CourseOffering offering) {
        ArrayList<Enrollment> offeringEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseOffering().equals(offering)) {
                offeringEnrollments.add(enrollment);
            }
        }
        return offeringEnrollments;
    }
    
    public ArrayList<Enrollment> getActiveEnrollments() {
        ArrayList<Enrollment> activeEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStatus().equals("ACTIVE")) {
                activeEnrollments.add(enrollment);
            }
        }
        return activeEnrollments;
    }
}
