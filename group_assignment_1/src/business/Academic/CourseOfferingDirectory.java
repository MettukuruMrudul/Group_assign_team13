/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Academic;
import java.util.ArrayList;
/**
 *
 * @author krishi
 */
public class CourseOfferingDirectory {
    private ArrayList<CourseOffering> courseOfferings;
    
    public CourseOfferingDirectory() {
        this.courseOfferings = new ArrayList<CourseOffering>();
    }
    
    public CourseOffering createCourseOffering(Course course, String semester, int capacity) {
        CourseOffering offering = new CourseOffering(course, semester, capacity);
        courseOfferings.add(offering);
        return offering;
    }
    
    public ArrayList<CourseOffering> getCourseOfferings() {
        return courseOfferings;
    }
    
    public CourseOffering findOffering(String offeringId) {
        for (CourseOffering offering : courseOfferings) {
            if (offering.getOfferingId().equals(offeringId)) {
                return offering;
            }
        }
        return null;
    }
    
    public ArrayList<CourseOffering> getOfferingsBySemester(String semester) {
        ArrayList<CourseOffering> semesterOfferings = new ArrayList<CourseOffering>();
        for (CourseOffering offering : courseOfferings) {
            if (offering.getSemester().equals(semester)) {
                semesterOfferings.add(offering);
            }
        }
        return semesterOfferings;
    }
    
    public ArrayList<CourseOffering> getOfferingsByCourse(String courseId) {
        ArrayList<CourseOffering> courseOfferingsList = new ArrayList<CourseOffering>();
        for (CourseOffering offering : courseOfferings) {
            if (offering.getCourse().getCourseId().equals(courseId)) {
                courseOfferingsList.add(offering);
            }
        }
        return courseOfferingsList;
    }
}