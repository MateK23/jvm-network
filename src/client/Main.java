package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 9090);
        // client created
        ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        outputStream.writeObject("Weather");
        // data sent


        ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
        String response = (String) objectInputStream.readObject();
        System.out.println(response);

        outputStream.close();
        clientSocket.close();
    }
}
