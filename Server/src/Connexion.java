import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Connexion extends UnicastRemoteObject implements IConnection {
    private final String  dataPath = "src/clientData.json";
    List<Client> clients;
    public Connexion(int port) throws IOException {
        super(port);
        clients.add(new Client("test", "test"));
        serializeClientData();
    }

    private void serializeClientData() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(dataPath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(clients);
    }

    private void deserializeClientData() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(dataPath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        clients = (List<Client>) objectInputStream.readObject();
    }

    @Override
    public boolean signIn(String mail, String password) {
        return false;
    }

    @Override
    public IVODService login(String mail, String password) {
        return null;
    }
}
