/**
 * @author Bonnet Kilian
 * @author IMAMI Ayoub
 *
 * VOD_RMI_project
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(2000);

            // Creating remote object
            Connexion connStub = new Connexion(2001);

            // Binding the stub in the registry
            registry.rebind("IConnection", connStub);

            System.out.println("Server ready!");

            JsonHelper jsonHelper = new JsonHelper();
            Movies movies = new Movies();
            Movie movie = movies.getStarWars();
            jsonHelper.serializeMovie(movie);

        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
}
