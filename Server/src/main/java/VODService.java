import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VODService extends UnicastRemoteObject implements IVODService {
    private List<Movie> moviesList;
    private final JsonHelper jsonHelper;

    private final BigInteger outrageousPrice = BigInteger.valueOf(20);

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

    /**
     * Send the chunk to the client boxStub
     * @param isbn of the movie
     * @param boxStub of the client
     * @return the movie Bill
     * @throws RemoteException exception
     * @throws InterruptedException exception
     */
    @Override
    public Bill playMovie(String isbn, IClientBox boxStub) throws RemoteException, InterruptedException {
        Bill movieBill = null;

        for(Movie movie : moviesList) {
            if(movie.getIsbn().equals(isbn)) {
                boxStub.stream(movie.getChunk());
                String name = movie.getMovieName();
                movieBill = new Bill(name, outrageousPrice);
            }
        }

        return movieBill;
    }
}

