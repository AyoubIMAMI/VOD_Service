import java.io.Serializable;

public class Movie extends MovieDesc implements Serializable {
    private byte[] chunk;

    //empty constructor needed for JsonHelper
    Movie() {}

    Movie(String movieName, String isbn, byte[] chunk) {
        super(movieName, isbn);
        this.chunk = chunk;
    }

    /**
     * Setter is mandatory for Jackson serialisation
     * @param chunk The given chuck
     */
    public void setChunk(byte[] chunk) {
        this.chunk = chunk;
    }

    public byte[] getChunk() {
        return chunk;
    }
}
