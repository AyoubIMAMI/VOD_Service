import java.io.*;

public class Movies implements Serializable {

    //object creation
    String quote = "Use the force, luck.";
    byte[] starWarsChunk = quote.getBytes();
    Movie starWars = new Movie("Star Wars", "12345-54321-012", starWarsChunk);

    //filepath
    String filePath = "src/movies.txt";

    void serialize() throws IOException {
        //serialize the movie object
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new Movie("Star Wars", "12345-54321-012", starWarsChunk));
    }

    void deserialize() throws IOException, ClassNotFoundException {
        //serialize the movie object
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Movie deserializedUser = (Movie) objectInputStream.readObject();
    }

}
