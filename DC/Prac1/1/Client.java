import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address (use "localhost" for local testing)
        int port = 12345; // Server's port number
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected to the server at " + serverAddress + ":" + port);

            // Create input and output streams for communication with the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send a message to the server
            System.out.print("Enter message to send to the server: ");
            String message = userInput.readLine();
            output.println(message);

            // Receive the response from the server
            String serverResponse = input.readLine();
            System.out.println("Server says: " + serverResponse);

            // Close the streams and socket
            input.close();
            output.close();
            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
