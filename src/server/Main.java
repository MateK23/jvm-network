package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server is On...");
        // server on

        Socket clientSocket = serverSocket.accept();
        System.out.println("Conncetion accepted");
        // connected


        ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

        String response = (String) objectInputStream.readObject();
        System.out.println("Getting response");
        // getting response

        System.out.println("Response from client: " + response);
        // got response


        ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        System.out.println("mivige : "+ response);
        if (response.equals("Weather")){
            outputStream.writeObject("Its rainy here");

        }else {
            outputStream.writeObject("aaa");
        }

        objectInputStream.close();
        serverSocket.close();
    }
}
