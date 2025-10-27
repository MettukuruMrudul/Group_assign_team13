/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Academic;

/**
 *
 * @author DELL
 */
public class CourseOffering {
    private static int offeringIdCounter = 1000;
    
    private String offeringId;
    private Course course;
    private String semester; // e.g., "Fall 2024", "Spring 2025"
    private String facultyName;
    private int capacity;
    private int enrolled;
    private String roomNumber;
    private String schedule; // e.g., "Mon/Wed 10:00-11:30"
    
    public CourseOffering(Course course, String semester, int capacity) {
        this.offeringId = "OFF" + (offeringIdCounter++);
        this.course = course;
        this.semester = semester;
        this.capacity = capacity;
        this.enrolled = 0;
    }
    
    public String getOfferingId() {
        return offeringId;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public String getSemester() {
        return semester;
    }
    
    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public String getFacultyName() {
        return facultyName;
    }
    
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getEnrolled() {
        return enrolled;
    }
    
    public void incrementEnrolled() {
        if (enrolled < capacity) {
            this.enrolled++;
        }
    }
    
    public void decrementEnrolled() {
        if (enrolled > 0) {
            this.enrolled--;
        }
    }
    
    public boolean hasAvailableSeats() {
        return enrolled < capacity;
    }
    
    public String getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public String getSchedule() {
        return schedule;
    }
    
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    @Override
    public String toString() {
        return course.getCourseId() + " - " + course.getCourseName() + " (" + semester + ")";
    }
}
