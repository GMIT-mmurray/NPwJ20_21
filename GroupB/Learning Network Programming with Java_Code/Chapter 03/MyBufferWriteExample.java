

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.ConsoleHandler;
import java.util.logging.*;

//import org.apache.log4j.Logger;

public class MyBufferWriteExample {
    private static final Logger logger
            = Logger.getLogger(String.valueOf(MyBufferWriteExample.class));



    private static final int BUFFER_SIZE = 1024;
    private static final String FILE_NAME = "output.txt";
    private static final String QUOTE
            = "If your actions inspire others to dream more, learn "
            + "more, do  more and become more, you are a leader.";

    public static void main(String[] args) throws IOException {
        logger.info("Starting MyBufferWriteExample...");

        FileOutputStream fileOS = new FileOutputStream(FILE_NAME);
        FileChannel channel = fileOS.getChannel();
        logger.entering((MyBufferWriteExample.class.getName()),"doIt");
        logger.log(Level.SEVERE, "A severe message!");
        try {
            ByteBuffer myBuffer = ByteBuffer.allocate(BUFFER_SIZE);
            myBuffer.put(QUOTE.getBytes());
            myBuffer.flip();
            int bytesWritten = channel.write(myBuffer);
            logger.info(String.format("%d bytes have been written to disk...",bytesWritten));
            logger.info(String.format("Current buffer position is %d", myBuffer.position()));
        } finally {
            channel.close();
            fileOS.close();
        }
    }
}