import java.net.*;
import java.io.*;

public class UserHandler extends Thread {
    private final Server server;
    private final Socket client;
    private PrintWriter writer;

    UserHandler(Socket client, Server server) {
        this.server = server;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream(), true);

            String serverMessage = "New user has connected!";
            server.broadcast(serverMessage, this);

            String msg;

            while(true) {
                msg = reader.readLine();
                server.broadcast(msg, this);
            }

        } catch (IOException ex) {
            server.broadcast("User disconnected.", this);
            this.stop();
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }
}
