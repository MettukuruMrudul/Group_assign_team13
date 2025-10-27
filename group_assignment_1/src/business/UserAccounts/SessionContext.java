package business.UserAccounts;

import business.UserAccounts.UserAccount;

/**
 * 
 * 
 * @author krishi
 */
public class SessionContext {

    private static SessionContext instance;
    private UserAccount currentUser;

    private SessionContext() {}

    public static SessionContext getInstance() {
        if (instance == null) {
            instance = new SessionContext();
        }
        return instance;
    }

    public void setUser(UserAccount ua) { this.currentUser = ua; }
    public UserAccount getUser() { return currentUser; }

    public void logout() { currentUser = null; }
}
