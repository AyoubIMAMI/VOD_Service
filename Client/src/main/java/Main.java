import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static java.lang.System.exit;

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

            // Client provides a stub of its "internet box" (for the server to stream back the video)
            IClientBox box = new ClientBox(2003);

            // UserUI VodService loop
            while(true){
                int answer = userUI.serviceAsk();
                if (answer == 0) exit(0);

                if(answer == 1) {
                    userUI.printCatalog(vodServiceStub.viewCatalog());
                    String selectedMovie = userUI.selectMovie(vodServiceStub.viewCatalog());
                    vodServiceStub.playMovie(selectedMovie, box);
                }
            }

        }
        catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }

    }
}
