import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("temp.txt");
        write(path);
        read(path);
    }

    private static void write(Path path) throws IOException {
        String input = "NIO Buffer Hello World!";
        byte[] inputBytes = input.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(inputBytes);
        FileChannel channelWrite = FileChannel.open(path,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        channelWrite.write(byteBuffer);
        channelWrite.close();
    }

    private static void read(Path path) throws IOException {
        FileChannel channelRead = FileChannel.open(path);
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channelRead.read(byteBuffer);
        byte[] byteArray = byteBuffer.array();
        String fileContent = new String(byteArray).trim();
        System.out.println("File Content: " + fileContent);
        channelRead.close();
    }
}

/*
import java.io.IOException;
        import java.io.RandomAccessFile;
        import java.nio.ByteBuffer;
        import java.nio.channels.FileChannel;

public class ChannelExample {
    public static void main(String args[]) throws IOException {
        RandomAccessFile file = new RandomAccessFile("temp.txt", "r");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (fileChannel.read(byteBuffer) > 0) {
            // flip the buffer to prepare for get operation
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            // clear the buffer ready for next sequence of read
            byteBuffer.clear();
        }
        file.close();
    }
}*/
