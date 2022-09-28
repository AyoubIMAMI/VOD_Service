import java.io.Serializable;

public class Client implements Serializable {
    //mail of the client
    private final String mail;
    //password of the client
    private final String password;
    //client interface
    private IClientBox clientBox;

    Client (String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    /**
     * Check if the password matches the mail
     * @param password of the user
     * @return true if the password matches the login (mail)
     */
    boolean checkCredential(String password) {
        return true;
    }
}
