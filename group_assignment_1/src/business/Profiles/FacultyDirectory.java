package business.Profiles;

import java.util.ArrayList;
import business.Person.Person;

/**
 *
 * @author krishi
 */
public class FacultyDirectory {

    private ArrayList<FacultyProfile> facultyList;

    public FacultyDirectory() {
        facultyList = new ArrayList<>();
    }

    public FacultyProfile newFacultyProfile(Person p) {
        FacultyProfile fp = new FacultyProfile(p);
        facultyList.add(fp);
        return fp;
    }

    public ArrayList<FacultyProfile> getFacultyList() {
        return facultyList;
    }
}
