import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {

    //movie's attribute
    private String movieName;
    private String isbn;
    private byte[] chunk;

    Movie(String movieName, String isbn, byte[] chunk) {
        this.movieName = movieName;
        this.isbn = isbn;
        this.chunk = chunk;
    }

}
