package business.Person;

import business.Person.Person;
import java.util.ArrayList;

/**
 * 
 * 
 * @author krishi
 */
public class PersonDirectory {

    private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public Person newPerson(String name) {
        Person p = new Person(name);
        personList.add(p);
        return p;
    }

    public Person findPersonById(String id) {
        for (Person p : personList) {
            if (p.getPersonId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
}
