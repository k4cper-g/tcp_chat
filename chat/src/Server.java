import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server extends Thread{
    private final UI ui;
    private ServerSocket serverSocket;
    private final List<UserHandler> users;
    private int port;
    private String ip;
    private String userName;
    private Client client;


    Server(int port, UI ui) {
        this.ui = ui;
        this.port = port;
        this.users = new ArrayList<>();
        this.client = new Client(ip,port,userName,ui);
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server waiting on " + port + "...");

        this.client = new Client(ip, port, userName, ui);
        client.startClient();

        while(true) {
            try {
                Socket clientSocket = serverSocket.accept();
                UserHandler user = new UserHandler(clientSocket, this);
                users.add(user);
                user.start();
            } catch (IOException e) {
                System.out.println("Connection problem.");
                e.printStackTrace();
                break;
            }

        }
    }
    public void broadcast(String message, UserHandler exclude) {
        for(UserHandler user: users) {
            if(user != exclude) {
                user.sendMessage(message);
            }
        }
    }
    public void setPort(int port) {
        this.port = port;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
}
