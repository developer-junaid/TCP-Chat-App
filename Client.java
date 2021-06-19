import java.io.*; // {Scanner}
import java.net.*; // {Socket}
import java.util.*; // {PrintWriter}

// Client
public class Client {

    // Main
    public static void main(String[] args) throws Exception {
        System.out.println("Connecting to server ...\n");

        Socket link = new Socket(InetAddress.getLocalHost(), 8081); // Step 1: Server connection request

        System.out.println("Send message to server");
        // create streams Step 2, 3 and 4
        Scanner input = new Scanner(link.getInputStream());
        PrintWriter output = new PrintWriter(link.getOutputStream(), true);
        Scanner cmdInput = new Scanner(System.in); // Get input from user's screen

        // Step 5: Echo messages untill "close"
        String msg = "";

        while (!msg.equalsIgnoreCase("close")) {
            // Echo
            msg = cmdInput.nextLine(); // Get from input user
            output.println(msg); // Send to server
            msg = input.nextLine(); // Get from server
            System.out.println("Server Says: " + msg); // Print
        }

        link.close(); // Close Connection
    }
}