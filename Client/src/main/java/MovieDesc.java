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

    /**
     * Setter is mandatory for Jackson serialisation
     * @param movieName The given movieName
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * Setter is mandatory for Jackson serialisation
     * @param isbn The given isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    String getIsbn() {
        return this.isbn;
    }

    @Override
    public String toString() {
        return movieName + " (isbn: " + isbn +")";
    }
}
