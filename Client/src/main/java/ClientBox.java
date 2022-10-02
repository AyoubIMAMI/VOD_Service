import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;

public class ClientBox extends UnicastRemoteObject implements IClientBox {

    protected ClientBox(int port) throws IOException {
        super(port);
    }

    @Override
    public void stream(byte[] chunk) {
        System.out.println(chunk);
    }
}
