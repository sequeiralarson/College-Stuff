import java.io.*;
import java.net.*;
    public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("10.4.0.194", 12345)) { 
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

              System.out.println("Enter a message to send to the server:");
            String message = reader.readLine();
            writer.println(message);

             String serverMessage = serverReader.readLine();
            System.out.println("Server says: " + serverMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }}}
