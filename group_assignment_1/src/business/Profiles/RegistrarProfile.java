package business.Profiles;

import business.Person.Person;

/**
 * 
 * @author krishi
 */
public class RegistrarProfile extends Profile {
    
    private String officeLocation;
    private String officeHours;
    private String email;
    private String phoneNumber;

    public RegistrarProfile(Person p) {
        super(p, "REGISTRAR");
        this.email = p.getName().toLowerCase().replace(" ", ".") + "@university.edu";
    }
    
    public String getOfficeLocation() {
        return officeLocation;
    }
    
    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }
    
    public String getOfficeHours() {
        return officeHours;
    }
    
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
