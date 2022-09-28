/**
 * @author Bonnet Kilian
 * @author IMAMI Ayoub
 *
 * VOD_RMI_project
 */

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(2000);

            // Creating remote object
            Connexion connStub = new Connexion(2001);

            // Binding the stub in the registry
            registry.rebind("IConnection", connStub);

            System.out.println("Server ready!");

            Movies movies = new Movies();
            movies.serialize();

        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
}
