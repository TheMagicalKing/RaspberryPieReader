package PieReadTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class PieReadClient {

    static int port = 8192;
    static String host = "localhost";
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
                Scanner msg = new Scanner(System.in);
                System.out.println("1 for at lukke clienten");
                System.out.println("Send a message!");
                out.writeUTF(msg.nextLine());
                out.flush();
                System.out.println(in.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
