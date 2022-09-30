import java.io.Serializable;

public class Movie implements Serializable {

    //empty constructor needed for JsonHelper
    Movie() {}

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
