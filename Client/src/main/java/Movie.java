import java.io.Serializable;

public class Movie extends MovieDesc implements Serializable {
    private byte[] chunk;

    //empty constructor needed for JsonHelper
    Movie() {}


    Movie(String movieName, String isbn, byte[] chunk) {
        super(movieName, isbn);
        this.chunk = chunk;
    }
}
