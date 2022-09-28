import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

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
     * @return - true/false: if the new account is successfully added to the client list
     * @throws RemoteException - Problem occurring during the networking
     */
    @Override
    public boolean signIn(String mail, String password) throws RemoteException {
        // Check if a client already had this email
        if (clients.stream().anyMatch(client -> client.getMail().equals(mail)))
            return false;

        System.out.println("[INFO] New user '" + mail + "' added to database.");
        clients.add(new Client(mail, password));
        return true;
    }

    @Override
    public IVODService login(String mail, String password) throws RemoteException {
        System.out.println("[INFO] " + mail + " is attempting to log in");
        return vodService;
    }
}
