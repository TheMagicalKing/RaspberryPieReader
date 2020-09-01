package PieReadTest;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class PieReadClient{

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
            boolean serverMsg = true;
//            while (serverMsg = true) {
                byte[] message = in.readAllBytes();
                String strMessage = new String(message, StandardCharsets.UTF_8);
                byte[] byteTemp = in.readAllBytes();
                String temp = new String(byteTemp,StandardCharsets.UTF_8);
                byte[] byteHumid = in.readAllBytes();
                String humid = new String(byteHumid, StandardCharsets.UTF_8);
                System.out.println(strMessage + ' ' + temp + ' ' + humid);
                Thread.sleep(5000);
                socket.close();


            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
