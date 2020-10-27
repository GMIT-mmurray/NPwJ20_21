

import java.nio.channels.SocketChannel;

public class ClientHandler implements Runnable{

    private final SocketChannel socketChannel;
    private  final int clientNumber;

    public ClientHandler(SocketChannel socketChannel, int clientNumber) {
        this.socketChannel = socketChannel;
        this.clientNumber = clientNumber;
    }

    public void run() {
        System.out.println("ClientHandler Started for " + clientNumber+ " "+this.socketChannel);
        String partName;
        while (true) {
            partName = HelperMethods.receiveMessage(socketChannel);
            if (partName.equalsIgnoreCase("quit")) {
                break;
            } else {
                Float price = PartsServer.getPrice(partName);
                HelperMethods.sendMessage(socketChannel, "" + price);
            }
        }
        System.out.println("ClientHandler Terminated for " + this.socketChannel);
    }
}
