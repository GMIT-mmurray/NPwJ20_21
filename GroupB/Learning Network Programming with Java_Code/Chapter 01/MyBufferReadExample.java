import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



public class MyBufferReadExample {

    private static final int BUFFER_SIZE = 1024;
    private static final String FILE_NAME = "output.txt";

    public static void main(String[] args) throws IOException {

        FileInputStream fileIS = new FileInputStream(FILE_NAME);
        FileChannel inChannel = fileIS.getChannel();

        ByteBuffer myBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        while (inChannel.read(myBuffer) > 0) {
            myBuffer.flip();

            while (myBuffer.hasRemaining()) {
                System.out.print( (char)myBuffer.get());
            }
            myBuffer.clear();
        }

        inChannel.close();
        fileIS.close();
    }
}
