import java.io.Serializable;

public class MovieDesc implements Serializable {
    private String movieName;
    private String isbn;

    //empty constructor needed for JsonHelper
    MovieDesc() {}

    public MovieDesc(String movieName, String isbn){
        this.movieName = movieName;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return movieName + ": " + isbn;
    }
}
