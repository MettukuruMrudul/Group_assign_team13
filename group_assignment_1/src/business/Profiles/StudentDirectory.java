package business.Profiles;

import java.util.ArrayList;
import business.Person.Person;

/**
 * 
 * @author krishi
 */
public class StudentDirectory {

    private ArrayList<StudentProfile> studentList;

    public StudentDirectory() {
        studentList = new ArrayList<>();
    }

    public StudentProfile newStudentProfile(Person p) {
        StudentProfile sp = new StudentProfile(p);
        studentList.add(sp);
        return sp;
    }

    public ArrayList<StudentProfile> getStudentList() {
        return studentList;
    }
}
