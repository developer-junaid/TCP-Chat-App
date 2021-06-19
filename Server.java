import java.io.*; // {Scanner}
import java.net.*; // {ServerSocket, Socket}
import java.util.*; // {PrintWriter}

// Server
public class Server {
    // Main
    public static ServerSocket serverSock; // Define class

    public static void main(String[] args) throws Exception {
        System.out.println("Opening port ...\n");

        serverSock = new ServerSocket(8081); // Step 1: Start Server
        System.out.println("Server Running on port 8081 !!\n Waiting for client ...");

        Socket link = serverSock.accept(); // Step 2: Accept request, Establish connection

        // create streams Step 3 and 4
        Scanner input = new Scanner(link.getInputStream());
        PrintWriter output = new PrintWriter(link.getOutputStream(), true);

        // Step 5: Echo messages untill "close"
        String msg = "";

        while (!msg.equalsIgnoreCase("close")) {
            // Echo
            msg = input.nextLine(); // Get from client
            System.out.println("Client Says: " + msg); // Print
            output.println(msg); // Send to client
        }

        link.close(); // Close Connection
    }
}