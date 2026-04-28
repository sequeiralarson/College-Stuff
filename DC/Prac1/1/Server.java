import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Port number for the server
        try {
            // Create server socket and bind it to the specified port
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running and waiting for client connection...");

            // Accept a connection from a client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            // Create input and output streams for communication with the client
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Read the client's message
            String clientMessage = input.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Respond to the client
            String response = "Server received your message: " + clientMessage;
            output.println(response);

            // Close the streams and socket
            input.close();
            output.close();
            socket.close();
            serverSocket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
