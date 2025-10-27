/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Academic;

/**
 *
 * @author krishi
 */
public class CourseDirectory {
    private ArrayList<Course> courses;
    
    public CourseDirectory() {
        this.courses = new ArrayList<>();
        initializeCourses();
    }
    
    private void initializeCourses() {
        // Pre-populate with sample courses
        courses.add(new Course("CS101", "Introduction to Programming", "CS", 4));
        courses.add(new Course("CS201", "Data Structures", "CS", 4));
        courses.add(new Course("CS301", "Algorithms", "CS", 3));
        courses.add(new Course("MATH101", "Calculus I", "MATH", 4));
        courses.add(new Course("MATH201", "Linear Algebra", "MATH", 3));
        courses.add(new Course("BUS101", "Business Fundamentals", "BUS", 3));
        courses.add(new Course("ENG101", "Engineering Design", "ENG", 4));
    }
    
    public Course addCourse(String id, String name, String deptId, int credits) {
        Course course = new Course(id, name, deptId, credits);
        courses.add(course);
        return course;
    }
    
    public ArrayList<Course> getCourses() {
        return courses;
    }
    
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
    
    public ArrayList<Course> getCoursesByDepartment(String departmentId) {
        ArrayList<Course> deptCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDepartmentId().equals(departmentId)) {
                deptCourses.add(course);
            }
        }
        return deptCourses;
    }
}