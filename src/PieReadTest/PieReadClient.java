package PieReadTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class PieReadClient {

    static int port = 123456;
    static String host = "192.168.43.176";
    static DataInputStream in;
    static DataOutputStream out;
    static Socket socket;

    public static void main(String[] args) {
        try{
            System.out.println("Client startet");
            socket = new Socket(host,port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            boolean serverMsg = true;
            while (serverMsg = true){
                System.out.println(in.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
