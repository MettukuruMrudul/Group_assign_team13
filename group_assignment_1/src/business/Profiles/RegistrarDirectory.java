package business.Profiles;

import java.util.ArrayList;
import business.Person.Person;

/**
 * 
 * @author krishi
 */
public class RegistrarDirectory {

    private ArrayList<RegistrarProfile> registrarList;

    public RegistrarDirectory() {
        registrarList = new ArrayList<>();
    }

    public RegistrarProfile newRegistrarProfile(Person p) {
        RegistrarProfile rp = new RegistrarProfile(p);
        registrarList.add(rp);
        return rp;
    }

    public ArrayList<RegistrarProfile> getRegistrarList() {
        return registrarList;
    }
}
