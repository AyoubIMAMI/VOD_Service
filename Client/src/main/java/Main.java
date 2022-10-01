import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try{
            // Retrieve RMI registry
            Registry registry = LocateRegistry.getRegistry(2000);

            // Searching the remote object stub on the registry
            IConnection connectionStub = (IConnection) registry.lookup("IConnection");

            // Adding user interface
            UserUI userUI = new UserUI();

            // UserUI login loop
            IVODService vodServiceStub = null;
            while(vodServiceStub == null){
                int answer = userUI.loginRegisterAsk();
                if (answer == 0) return;

                String[] mailPass = userUI.getMailPass();
                if(answer == 1)
                    vodServiceStub = connectionStub.login(mailPass[0], mailPass[1]);

                if(answer == 2){
                    if (connectionStub.signIn(mailPass[0], mailPass[1]))
                        System.out.println("Successfully registered");
                    else
                        System.out.println("Mail already exists!");
                }
            }

            System.out.println();

            // UserUI VodService loop
            while(true){
                int answer = userUI.serviceAsk();
                if (answer == 0) return;

                if(answer == 1) userUI.printCatalog(vodServiceStub.viewCatalog());


                if(answer==2)
                    System.out.println("..."); // TODO: Add the stream to user ui
            }

        }
        catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }

    }
}
