import java.io.Serializable;

public class MovieDesc implements Serializable {
    private String movieName;
    private String isbn;
    private String synopsis;

    //empty constructor needed for JsonHelper
    MovieDesc() {}

    public MovieDesc(String movieName, String isbn, String synopsis){
        this.movieName = movieName;
        this.isbn = isbn;
        this.synopsis = synopsis;
    }

    String getIsbn() {
        return this.isbn;
    }

    String getMovieName() {
        return this.movieName;
    }

    String getSynopsis() {return this.synopsis;}

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

    /**
     * Setter is mandatory for Jackson serialisation
     * @param synopsis The given isbn
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return movieName + " (isbn: " + isbn +") - Synopsis: " + synopsis;
    }
}
