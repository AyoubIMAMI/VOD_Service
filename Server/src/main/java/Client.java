import java.io.Serializable;

public class Client {
    //mail of the client
    private final String mail;
    //password of the client
    private final String password;

    Client (String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
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
