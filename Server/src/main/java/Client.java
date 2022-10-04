import java.io.Serializable;

public class Client implements Serializable {

    //empty constructor needed for JsonHelper
    Client() {}

    //client mail
    private String mail;
    //client password
    private String password;
    //client interface
    private IClientBox clientBox;

    Client (String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    /**
     * Check if mails matches
     * @param mail of the client
     * @return true id the mails matches
     */
    public boolean checkMail(String mail) {
        return this.mail.equals(mail);
    }

    /**
     * Check if the password matches the mail
     * @param password of the user
     * @return true if the password matches the login (mail)
     */
    boolean checkCredential(String mail, String password) {
        return (this.mail.equals(mail) && this.password.equals(password));
    }

    public IClientBox getClientBox(){
        return clientBox;
    }

    /**
     * Setter is mandatory for Jackson serialisation
     * @param mail The given mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Setter is mandatory for Jackson serialisation
     * @param password The given password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter is mandatory for Jackson serialisation
     * @param clientBox The given clientBox
     */
    public void setClientBox(IClientBox clientBox) {
        this.clientBox = clientBox;
    }

    @Override
    public String toString() {
        return mail + ": " + password;
    }
}
