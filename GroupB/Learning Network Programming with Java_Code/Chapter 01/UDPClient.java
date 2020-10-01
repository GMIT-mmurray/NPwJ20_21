package packt;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

class UDPClient {

    public static void main(String args[]) throws Exception {
        final int portNumber = 9876;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
             DatagramSocket clientSocket = new DatagramSocket();) {

            String serverHostname = "127.0.0.1";
            InetAddress address = InetAddress.getByName(serverHostname);
            while (true) {
                System.out.print("Enter text: ");
//            String sentence = br.readLine();
                byte[] data = br.readLine().getBytes();
//            System.out.println("Sending data to " + sendData.length
//                    + " bytes to server.");
                DatagramPacket sendPacket = new DatagramPacket(
                        data, data.length, address, portNumber);
                clientSocket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket
                        = new DatagramPacket(receiveData, receiveData.length);

               clientSocket.receive(receivePacket);

                System.out.println("Waiting for return packet");
//            clientSocket.setSoTimeout(10000);
                InetAddress returnIPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                System.out.println("From server at: " + returnIPAddress
                        + ":" + port);
//                System.out.println("Message: " + modifiedSentence);

                System.out.println("Message: " + new String(receivePacket.getData()));
            }
        }
    }
}

