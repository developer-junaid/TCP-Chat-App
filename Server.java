import java.io.*; // {Scanner}
import java.net.*; // {ServerSocket, Socket}
import java.util.*; // {PrintWriter}

// Junaid Qureshi
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
        Scanner cmdInput = new Scanner(System.in); // Get input from user's screen

        // Step 5: Echo messages untill "close"
        String msg = "";

        while (!msg.equalsIgnoreCase("close")) {
            // 1 Take input from client
            // 2 Print client's message
            // 3 Ask server about message
            // 4 Send that to client
            // 5 Print server's message
            // Ask again
            msg = input.nextLine(); // Get from client
            System.out.println("Client Says: " + msg); // Print
            System.out.print("Send message to client: "); // Ask
            msg = cmdInput.nextLine(); // Ask server what to send
            output.println(msg); // Send to client
        }

        link.close(); // Close Connection
    }
}