import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConnection extends Remote {
    boolean signIn(String mail, String password) throws RemoteException;
    IVODService login(String mail, String password)throws RemoteException;
}
