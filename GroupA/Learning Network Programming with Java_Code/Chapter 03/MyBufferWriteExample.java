

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



public class MyBufferWriteExample {

    private static final int BUFFER_SIZE = 1024;
    private static final String FILE_NAME = "output.txt";
    private static final String QUOTE
            = "If your actions inspire others to dream more, learn "
            + "more, do  more and become more, you are a leader.";

    public static void main(String[] args) throws IOException {

        FileOutputStream fileOS = new FileOutputStream(FILE_NAME);
        FileChannel channel = fileOS.getChannel();

        try {
            ByteBuffer myBuffer = ByteBuffer.allocate(BUFFER_SIZE);
            myBuffer.put(QUOTE.getBytes());
            myBuffer.flip();

            int bytesWritten = channel.write(myBuffer);
            System.out.println("Bytes Written "+bytesWritten);

        } finally {
            channel.close();
            fileOS.close();
        }
    }
}


