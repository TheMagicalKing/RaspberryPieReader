package PieReadTest;

import javafx.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PieReadClient {

    static int port = 420;
    static String host = "192.168.50.89";
    static DataInputStream in;
    static DataOutputStream out;
    static Socket socket;

    public static void main(String[] args) {
        try{
            while (true){
            System.out.println("Client startet");
            socket = new Socket(host,port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            double temp, humid;
            boolean serverMsg = true;
//            while (serverMsg = true) {
                byte[] message = in.readAllBytes();
                String str = new String(message, StandardCharsets.UTF_8);
                temp = in.readDouble();
                humid = in.readDouble();
                System.out.println(str + ' ' + temp + ' ' + humid);
                Thread.sleep(5000);
                socket.close();

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
