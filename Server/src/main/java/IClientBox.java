import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientBox extends Remote {

    /**
     * Stream the movie to the client
     * @param chunk - data to send to the client
     */
    void stream(byte[] chunk) throws RemoteException, InterruptedException;
}
