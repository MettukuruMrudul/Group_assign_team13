package business.Profiles;

import business.Person.Person;

/**
 * 
 * 
 * @author krishi
 */
public abstract class Profile {

    protected Person person;
    protected String role;

    public Profile(Person p, String role) {
        this.person = p;
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return role + ": " + person.getName();
    }
}
