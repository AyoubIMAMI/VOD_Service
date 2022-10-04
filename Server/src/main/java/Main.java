import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Bonnet Kilian
 * @author IMAMI Ayoub
 *
 * VOD_RMI_project
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Create RMI registry
            Registry registry = LocateRegistry.createRegistry(2000);

            // Creating remote object
            Connection connStub = new Connection(2001);

            // Binding the stub in the registry
            registry.rebind("IConnection", connStub);

            System.out.println("Server ready!");

        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
}
