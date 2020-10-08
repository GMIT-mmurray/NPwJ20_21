import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTimeClient {

    private static void displayByteBuffer(ByteBuffer byteBuffer) {
        System.out.println("Capacity: " + byteBuffer.capacity()
                + " limit: " + byteBuffer.limit()
                + " position: " + byteBuffer.position());
    }

    public static void main(String[] args) {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
        try (SocketChannel socketChannel = SocketChannel.open(address)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            // displayByteBuffer(byteBuffer);
            int bytesRead;
            while (true) {
                bytesRead = socketChannel.read(byteBuffer);
                while (bytesRead > 0) {
                    byteBuffer.flip();
                    //displayByteBuffer(byteBuffer);
                    while (byteBuffer.hasRemaining()) {
                        System.out.print((char) byteBuffer.get());
                    }
                    byteBuffer.clear();
                    bytesRead = 0;
                    System.out.println();
                    //bytesRead = socketChannel.read(byteBuffer);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}