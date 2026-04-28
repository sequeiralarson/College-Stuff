import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server started");
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String msg = dis.readUTF();
            System.out.println("Client says: " + msg);
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }}}
