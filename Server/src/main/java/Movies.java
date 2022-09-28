import java.io.*;

public class Movies {

    //object creation
    String quote = "Use the force, luck.";
    byte[] starWarsChunk = quote.getBytes();
    Movie starWars = new Movie("Star Wars", "12345-54321-012", starWarsChunk);

    Movie getStarWars() {
        return starWars;
    }

}
