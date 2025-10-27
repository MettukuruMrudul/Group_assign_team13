package business.UserInterface;

import business.UserAccounts.UserAccountDirectory;
import business.UserAccounts.Role;
import business.Business;
import business.Person.Person;
import business.Person.PersonDirectory;
import business.Profiles.*;

/**
 * 
 * @author krishi
 */
public class ConfigureABusiness {

    public static Business initialize() {
        Business business = new Business("Digital University");

        PersonDirectory persons = business.getPersonDirectory();
        EmployeeDirectory employees = business.getEmployeeDirectory();
        FacultyDirectory faculties = business.getFacultyDirectory();
        StudentDirectory students = business.getStudentDirectory();
        RegistrarDirectory registrars = business.getRegistrarDirectory();
        UserAccountDirectory uad = business.getUserAccountDirectory();

        // --- Admin ---
        Person adminP = persons.newPerson("System Admin");
        EmployeeProfile adminProfile = employees.newEmployeeProfile(adminP);
        uad.newUserAccount(adminProfile, "admin", "****", Role.ADMIN);

        // --- Faculty ---
        for (int i = 1; i <= 10; i++) {
            Person fp = persons.newPerson("Faculty" + i);
            FacultyProfile fprof = faculties.newFacultyProfile(fp);
            uad.newUserAccount(fprof, "faculty" + i, "fac" + i, Role.FACULTY);
        }

        // --- Students ---
        for (int i = 1; i <= 10; i++) {
            Person sp = persons.newPerson("Student" + i);
            StudentProfile sprof = students.newStudentProfile(sp);
            uad.newUserAccount(sprof, "student" + i, "stud" + i, Role.STUDENT);
        }

        // --- Registrar ---
        Person regP = persons.newPerson("Registrar One");
        RegistrarProfile regProf = registrars.newRegistrarProfile(regP);
        uad.newUserAccount(regProf, "registrar", "reg123", Role.REGISTRAR);

        return business;
    }
}
