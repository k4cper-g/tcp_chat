import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClientReader extends Thread {
    private final Client client;
    private BufferedReader reader;

    ClientReader(Client client, Socket socket) {
        this.client = client;
        try {
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("reader problem");
            e.printStackTrace();
        }

    }

    public void run() {
        System.out.println("Client Reader ON");
        while(true) {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                client.getUi().getConnection().setText("Disconnected.");
                client.getUi().getArea().setEditable(false);
      //          e.printStackTrace();
                break;
            }
            System.out.println(line);
            client.getUi().getChat().append(line + "\n");
          //  "[" + client.getUi().getClientUserName() + "]:"
        }
    }
}
