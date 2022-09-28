import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Connexion extends UnicastRemoteObject implements IConnection {
    private List<Client> clients;
    private final VODService vodService = new VODService(2002);

    protected Connexion(int port) throws RemoteException {
        super(port);
        clients = new ArrayList<>(); // TODO: Retrieve clients from json deserialization
    }

    /**
     *
     * @param mail - The mail associated to the new account
     * @param password - The password associated to the new account
     * @return - boolean: if the new account is successfully added to the client list
     * @throws RemoteException - Problem occurring during the networking
     */
    @Override
    public boolean signIn(String mail, String password) throws RemoteException {
        // Check if a client already had this email
        if (clients.stream().anyMatch(client -> client.checkMail(mail)))
            return false;

        System.out.println("[INFO] New user '" + mail + "' added to database.");
        clients.add(new Client(mail, password));
        return true;
    }

    /**
     *
     * @param mail - The mail associated to the new account
     * @param password - The password associated to the new account
     * @return - An IVODService if the client successfully logged in, null otherwise
     * @throws RemoteException - Problem occurring during the networking
     */
    @Override
    public IVODService login(String mail, String password) throws RemoteException {
        System.out.println("[INFO] " + mail + " is attempting to log in");

        // Check if a client had the given email and the given password
        if(clients.stream().filter(client -> client.checkMail(mail)).anyMatch(client -> client.checkPass(password)))
            return vodService;

        return null;
    }
}
