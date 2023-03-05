import javax.swing.*;
import java.io.*;
import java.net.*;

public class Client {
    private final UI ui;
    private String hostname;
    private int port;
    private String userName;

    Client(String host, int port, String userName, UI ui) {
        this.ui = ui;
        this.hostname = host;
        this.port = port;
        this.userName = userName;
    }

    public void startClient() {
        try {
            Socket clientSocket = new Socket(hostname, port);
            System.out.println("Connected!");
            ClientReader reader = new ClientReader(this, clientSocket);
            reader.start();
            ClientWriter writer = new ClientWriter(this, clientSocket);
            writer.start();


        } catch (IOException e) {
            JOptionPane.showMessageDialog(ui.getFrame(), "You cannot join a non-existing server!", "Error.", JOptionPane.ERROR_MESSAGE);
            ui.setClientFlag(false);
            e.printStackTrace();
        }
    }
    public void setPort(int port) {
        this.port = port;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public UI getUi() {
        return ui;
    }
}
