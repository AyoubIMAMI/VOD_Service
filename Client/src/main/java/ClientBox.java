import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.rmi.server.UnicastRemoteObject;

public class ClientBox extends UnicastRemoteObject implements IClientBox {

    protected ClientBox(int port) throws IOException {
        super(port);
    }

    /**
     * Count the length of the word in the chunk: stop at every space which code is 32 or stop at the end
     * @param startingPosition position from which the method start counting
     * @param chunk in which there is the word
     * @return the length of the word
     */
    private int wordLength(int startingPosition, byte[] chunk) {
        int chunkLength = chunk.length;
        int wordLength = 0;

        for (int i = startingPosition; i < chunkLength; i++) {
            if (chunk[i] != 32) wordLength++;
            else return wordLength;
        }

        return wordLength;
    }

    /**
     * Copy the part of the chunk to send into another chunk which will be sent
     * @param startingPosition position from which the method start copying
     * @param wordLength length to copy
     * @param chunk source of the copy
     * @return the chunk ready to be sent
     */
    private byte[] chunkToSend(int startingPosition, int wordLength, byte[] chunk) {
        byte[] chunkToSend = new byte[wordLength];
        System.arraycopy(chunk, startingPosition, chunkToSend, 0, wordLength);
        return chunkToSend;
    }

    /**
     * Stream: print to the client the chunk part by part
     * @param chunk data to send to the client
     * @throws InterruptedException sleep to simulate fps: frame per second (word per second here)
     */
    @Override
    public void stream(byte[] chunk) throws InterruptedException {
        int startingPosition = 0;
        int chunkLength = chunk.length;

        while(startingPosition < chunkLength) {
            int wordLength = wordLength(startingPosition, chunk);
            byte[] chunkToSend = chunkToSend(startingPosition, wordLength, chunk);
            startingPosition += wordLength;
            startingPosition++;
            System.out.println(new String(chunkToSend, StandardCharsets.UTF_8));
            Thread.sleep(1000);
        }

        System.out.println();
    }
}
