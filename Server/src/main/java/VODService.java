import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VODService extends UnicastRemoteObject implements IVODService {
    private List<Movie> moviesList;
    private final JsonHelper jsonHelper;

    protected VODService(int port) throws IOException {
        super(port);

        // Deserialize movies.json
        jsonHelper = new JsonHelper();
        moviesList = jsonHelper.deserializeMovies();
    }

    /**
     * Client may ask the server to get the list of MovieDesc.
     * @return The list of MovieDesc present in our server.
     */
    @Override
    public List<MovieDesc> viewCatalog() {
        return new ArrayList<>(moviesList);
    }

    @Override
    public Bill playMovie(String isbn, IClientBox box) {

        for(Movie movie : moviesList) {
            if(movie.getIsbn().equals(isbn)) box.stream(movie.getChunk());
        }
        return new Bill();
    }
}

