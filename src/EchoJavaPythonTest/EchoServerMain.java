package EchoServerTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServerMain {

    static int port = 8192;


    static OutputStream out;
    static ServerSocket server;
    static Socket socket;




    public static void main(String[] args) {
        BufferedInputStream in;



        try{
            System.out.println("Server startet");
            server = new ServerSocket(port);
            socket = server.accept();
            while (true) {

            System.out.println("Connection from Python made!");
            in = new BufferedInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            boolean goodbye = false;

              String hej = new String(in.readAllBytes(), StandardCharsets.UTF_8);
              System.out.println(hej);
              //out.writeBytes(hej);

          }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


