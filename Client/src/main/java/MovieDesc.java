public class MovieDesc {
    private String movieName;
    private String isbn;

    @Override
    public String toString() {
        return movieName + ": " + isbn;
    }
}
