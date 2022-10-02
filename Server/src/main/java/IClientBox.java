import java.rmi.Remote;

public interface IClientBox extends Remote {

    /**
     * Stream the movie to the client
     * @param chunk data to send to the client
     */
    void stream(byte[] chunk);
}
