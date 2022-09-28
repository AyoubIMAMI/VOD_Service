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
            // Create RMI registry
            Registry registry = LocateRegistry.createRegistry(2000);

            // Creating remote object
            Connexion connStub = new Connexion(2001);

            // Binding the stub in the registry
            registry.rebind("IConnection", connStub);

            System.out.println("Server ready!");

            // Initializing the movies catalogue: filling up the list of Movies
            Movies movies = new Movies();
            movies.initializeMoviesCatalogue();

            // Serializing the movies: filling up the json
            JsonHelper jsonHelper = new JsonHelper();
            jsonHelper.serializeMovies(movies.getMoviesList());

        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
}
