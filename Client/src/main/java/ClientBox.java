import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.rmi.server.UnicastRemoteObject;

public class ClientBox extends UnicastRemoteObject implements IClientBox {

    protected ClientBox(int port) throws IOException {
        super(port);
    }

    private int wordLength(int startingPosition, byte[] chunk) {
        int chunkLength = chunk.length;
        int wordLength = 0;

        for (int i = startingPosition; i < chunkLength; i++) {
            if (chunk[i] != 32) wordLength++;
            else return wordLength;
        }

        return wordLength;
    }

    private byte[] chunkToSend(int byteCursor, int wordLength, byte[] chunk) {
        byte[] chunkToSend = new byte[wordLength];
        System.arraycopy(chunk, byteCursor, chunkToSend, 0, wordLength);
        return chunkToSend;
    }

    @Override
    public void stream(byte[] chunk) throws InterruptedException {
        int byteCursor = 0;
        int chunkLength = chunk.length;

        while(byteCursor < chunkLength) {
            int wordLength = wordLength(byteCursor, chunk);
            byte[] chunkToSend = chunkToSend(byteCursor, wordLength, chunk);
            byteCursor += wordLength;
            byteCursor++;
            System.out.println(new String(chunkToSend, StandardCharsets.UTF_8));
            Thread.sleep(1000);
        }

    }
}
