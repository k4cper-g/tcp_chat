import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.*;
import java.io.*;

public class ClientWriter extends Thread{
    private final Client client;
    private PrintWriter writer;

    ClientWriter(Client client, Socket socket) {
        this.client = client;
        try {
            this.writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("writer problem");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Client Writer ON");
            client.getUi().field.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        client.getUi().chat.append("[You]: " + client.getUi().field.getText() + "\n");
                        writer.println("[" + client.getUserName() + "]: " + client.getUi().field.getText());
                        client.getUi().field.setText("");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
            client.getUi().send.addActionListener(e -> {
                String text = client.getUi().field.getText();
                if (!text.isEmpty()) {
                    client.getUi().chat.append("[You]: " + client.getUi().field.getText() + "\n");
                    writer.println("[" + client.getUserName() + "]: " + client.getUi().field.getText());
                    client.getUi().field.setText("");
                }
            });
       }
}
