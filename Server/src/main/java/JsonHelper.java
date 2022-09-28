import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonHelper {

    //ObjectMapper to write and read a json
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    //filepath
    private final String movieFilePath = "src/main/resources/movies.json";
    private final String clientFilePath = "src/main/resources/client.json";

    /**
     * Serialize the movies
     * @param moviesToSerialize to serialize
     * @throws IOException exception
     */
    void serializeMovies(List<Movie> moviesToSerialize) throws IOException {
        objectMapper.writeValue(new File(movieFilePath), moviesToSerialize);
    }

    /**
     * Deserialize the movies
     * @return the deserialized movies
     * @throws IOException exception
     */
    Movie deserializeMovies() throws IOException {
        return objectMapper.readValue(new File(movieFilePath), Movie.class);
    }

    /**
     * Serialize the clients
     * @param clientsToSerialize to serialize
     * @throws IOException exception
     */
    void serializeClients(List<Movie> clientsToSerialize) throws IOException {
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.writeValue(new File(clientFilePath), clientsToSerialize);
    }

    /**
     * Deserialize the movies
     * @return the deserialized movies
     * @throws IOException exception
     */
    Client deserializeClients() throws IOException {
        return objectMapper.readValue(new File(clientFilePath), Client.class);
    }
}
