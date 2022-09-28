import java.util.ArrayList;
import java.util.List;

public class Movies {

    //list of movies
    List<Movie> moviesList = new ArrayList<>();

    /**
     * Fill up the list of movies that can be serialized
     */
    void initializeMoviesCatalogue() {
        moviesList.add(new Movie("Star Wars", "12345-54321-000", "Use the force, luck.".getBytes()));
        moviesList.add(new Movie("Jurassic Park", "12345-54321-001", "Welcome to Jurassic Park.".getBytes()));
        moviesList.add(new Movie("Back To The Future", "12345-54321-002", "This is Heavy!".getBytes()));
    }

}
