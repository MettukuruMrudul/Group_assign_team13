package business;

import business.Person.PersonDirectory;
import business.Profiles.EmployeeDirectory;
import business.Profiles.StudentDirectory;
import business.Profiles.FacultyDirectory;
import business.Profiles.RegistrarDirectory;
import business.UserAccounts.UserAccountDirectory;
import business.Academic.*;
import business.Finance.*;


/**
 * Root container for the Digital University business structure.
 * @author Manav
 */
public class Business {

    private String name;

    private PersonDirectory personDirectory;
    private EmployeeDirectory employeeDirectory;
    private FacultyDirectory facultyDirectory;
    private StudentDirectory studentDirectory;
    private RegistrarDirectory registrarDirectory;
    private UserAccountDirectory userAccountDirectory;
    
    // Academic directories
    private DepartmentDirectory departmentDirectory;
    private CourseDirectory courseDirectory;
    private CourseOfferingDirectory courseOfferingDirectory;
    private EnrollmentDirectory enrollmentDirectory;
    
    // Finance directory
    private TuitionPaymentDirectory tuitionPaymentDirectory;

    public Business(String name) {
        this.name = name;
        this.personDirectory = new PersonDirectory();
        this.employeeDirectory = new EmployeeDirectory();
        this.facultyDirectory = new FacultyDirectory();
        this.studentDirectory = new StudentDirectory();
        this.registrarDirectory = new RegistrarDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        
        // Initialize academic directories
        this.departmentDirectory = new DepartmentDirectory();
        this.courseDirectory = new CourseDirectory();
        this.courseOfferingDirectory = new CourseOfferingDirectory();
        this.enrollmentDirectory = new EnrollmentDirectory();
        
        // Initialize finance directory
        this.tuitionPaymentDirectory = new TuitionPaymentDirectory();
    }

    public String getName() { return name; }

    public PersonDirectory getPersonDirectory() { return personDirectory; }
    public EmployeeDirectory getEmployeeDirectory() { return employeeDirectory; }
    public FacultyDirectory getFacultyDirectory() { return facultyDirectory; }
    public StudentDirectory getStudentDirectory() { return studentDirectory; }
    public RegistrarDirectory getRegistrarDirectory() { return registrarDirectory; }
    public UserAccountDirectory getUserAccountDirectory() { return userAccountDirectory; }
    
    // Academic getters
    public DepartmentDirectory getDepartmentDirectory() { return departmentDirectory; }
    public CourseDirectory getCourseDirectory() { return courseDirectory; }
    public CourseOfferingDirectory getCourseOfferingDirectory() { return courseOfferingDirectory; }
    public EnrollmentDirectory getEnrollmentDirectory() { return enrollmentDirectory; }
    
    // Finance getter
    public TuitionPaymentDirectory getTuitionPaymentDirectory() { return tuitionPaymentDirectory; }
}