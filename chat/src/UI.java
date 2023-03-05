import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createEmptyBorder;

public class UI {
    private final JFrame frame;
    public JButton send;
    private final JPanel mainPanel;
    private final JPanel hostPanel;
    private final JPanel joinPanel;
    public final JTextArea chat;
    private JScrollPane scrollField;
    private JScrollPane scrollChat;
    public JTextField field;
    private final JLabel connection;
    private JMenuItem joinMenu;
    private JMenuItem host;
    private final JMenuBar menu;
    private JPanel topFlow;
    private JPanel botFlow;
    private int port;
    private String ip;
    private String clientServerUserName;
    private String clientUserName;
    private boolean clientFlag = true;
    private final JMenu options;

   public UI() {
       this.send = new JButton();
       this.frame = new JFrame("szenkos's Chat");
       this.mainPanel = new JPanel();
       this.hostPanel = new JPanel();
       this.joinPanel = new JPanel();
       this.mainPanel.setPreferredSize(new Dimension(500,500));
       this.mainPanel.setLayout(new BorderLayout());
       this.mainPanel.setBorder(new EmptyBorder(10,10,10,10));
       this.chat = new JTextArea();
       this.field = new JTextField(30);
       this.field.setEditable(false);
       this.connection = new JLabel();
       this.menu = new JMenuBar();
       this.joinMenu = new JMenuItem();
       this.host = new JMenuItem();
       this.port = 12000;
       this.options = new JMenu("Options");
       this.ip = "";
       this.clientUserName = "";
       this.clientServerUserName = "";
       this.frame.add(mainPanel);

    }
    public void startApp() {
        menu();
        top();
        mid();
        bot();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
    public void menu() {
        JMenu theme = new JMenu("Theme");
        JMenuItem hacker = new JMenuItem("Hacker");
        JMenuItem pinkParadise = new JMenuItem("Pink Paradise");
        JMenuItem lightMode = new JMenuItem("Light Mode");
        JMenuItem darkMode = new JMenuItem("Dark Mode");

        hacker.addActionListener(e -> {
            mainPanel.setBackground(Color.BLACK);
            topFlow.setBackground(Color.BLACK);
            botFlow.setBackground(Color.BLACK);
            send.setForeground(Color.WHITE);
            send.setFocusPainted(false);
            send.setBackground(Color.BLACK);
            send.setBorder(createEmptyBorder());
            send.setBorder(new LineBorder(Color.WHITE));
            send.setPreferredSize(new Dimension(64,26));
            field.setBackground(Color.BLACK);
            field.setForeground(Color.GREEN);
            field.setBorder(new LineBorder(Color.WHITE));
            scrollField.setBorder(createEmptyBorder());
            connection.setForeground(Color.WHITE);
            chat.setForeground(Color.GREEN);
            chat.setBorder(new LineBorder(Color.WHITE));
            scrollChat.setBorder(createEmptyBorder());
            chat.setBackground(Color.BLACK);
        });
        darkMode.addActionListener(e -> {
            mainPanel.setBackground(Color.DARK_GRAY);
            topFlow.setBackground(Color.DARK_GRAY);
            botFlow.setBackground(Color.DARK_GRAY);
            send.setForeground(Color.WHITE);
            send.setBackground(Color.GRAY);
            send.setBorder(createEmptyBorder());
            send.setBorder(new LineBorder(Color.BLACK));
            send.setPreferredSize(new Dimension(64,26));
            field.setBackground(new Color(80,80,80));
            field.setBorder(new LineBorder(Color.BLACK));
            field.setForeground(Color.WHITE);
            connection.setForeground(Color.WHITE);
            chat.setForeground(Color.white);
            chat.setBackground(new Color(80,80,80));
            chat.setBorder(new LineBorder(Color.BLACK));
            scrollField.setBorder(createEmptyBorder());
            scrollChat.setBorder(createEmptyBorder());
        });
        lightMode.addActionListener(e -> {
            mainPanel.setBackground(Color.WHITE);
            topFlow.setBackground(Color.WHITE);
            botFlow.setBackground(Color.WHITE);
            send.setForeground(Color.BLACK);
            send.setBackground(Color.WHITE);
            send.setBorder(createEmptyBorder());
            send.setBorder(new LineBorder(Color.BLACK));
            send.setPreferredSize(new Dimension(64,26));
            field.setBackground(Color.WHITE);
            field.setBorder(new LineBorder(Color.BLACK));
            field.setForeground(Color.BLACK);
            connection.setForeground(Color.BLACK);
            chat.setForeground(Color.white);
            chat.setBackground(Color.white);
            chat.setBorder(new LineBorder(Color.BLACK));
            scrollField.setBorder(createEmptyBorder());
            scrollChat.setBorder(createEmptyBorder());
        });
        pinkParadise.addActionListener(new ActionListener() {
            final Color pink = new Color(255,212,252);
            final Color dark_pink = new Color(255,131,243);
            final Color dark_purple = new Color(85,0,77);
            final Color light_pink = new Color(255,233,254);

            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBackground(pink);
                topFlow.setBackground(pink);
                botFlow.setBackground(pink);
                send.setForeground(dark_purple);
                send.setBackground(light_pink);
                send.setBorder(createEmptyBorder());
                send.setBorder(new LineBorder(dark_pink));
                send.setPreferredSize(new Dimension(64,26));
                field.setBackground(light_pink);
                field.setBorder(new LineBorder(dark_pink));
                field.setForeground(dark_purple);
                connection.setForeground(dark_purple);
                chat.setForeground(dark_purple);
                chat.setBackground(light_pink);
                chat.setBorder(new LineBorder(dark_pink));
                scrollField.setBorder(createEmptyBorder());
                scrollChat.setBorder(createEmptyBorder());
            }
        });
        joinMenu = new JMenuItem("Join");
        host = new JMenuItem("Host");

        join();
        host();

        theme.add(hacker);
        theme.add(pinkParadise);
        theme.add(lightMode);
        theme.add(darkMode);

        options.add(joinMenu);
        options.add(host);
        menu.add(theme);
        menu.add(options);
        options.add(menu);

        this.frame.setJMenuBar(menu);
    }
    public void join() {
        JLabel usernameL = new JLabel("Username:");
        JLabel ipL = new JLabel("IP:");
        JLabel portL = new JLabel("Port:");
        JButton join = new JButton("Join");
        JButton back = new JButton("Back");

        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setAlignmentY(Component.CENTER_ALIGNMENT);
        join.setAlignmentX(Component.CENTER_ALIGNMENT);
        join.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel users = new JPanel();
        JPanel ips = new JPanel();
        JPanel ports = new JPanel();

        JTextField portF = new JTextField(10);
        JTextField ipF = new JTextField(10);
        JTextField usernameF = new JTextField(10);

        JLabel errorPort = new JLabel("Invalid port.");
        errorPort.setForeground(Color.RED);
        errorPort.setVisible(false);

        JLabel errorUser = new JLabel("Invalid username.");
        errorUser.setForeground(Color.RED);
        errorUser.setVisible(false);

        JLabel errorIp = new JLabel("Invalid IP.");
        errorIp.setForeground(Color.RED);
        errorIp.setVisible(false);

        joinPanel.add(users);
        joinPanel.add(ips);
        joinPanel.add(ports);
        users.add(usernameL);
        users.add(usernameF);
        users.add(errorUser);
        ips.add(ipL);
        ips.add(ipF);
        ips.add(errorIp);
        ports.add(portL);
        ports.add(portF);
        ports.add(errorPort);
        joinPanel.add(back);
        joinPanel.add(join);

        joinPanel.setBorder(new EmptyBorder(10,10,10,10));

        joinPanel.setLayout(new BoxLayout(joinPanel, BoxLayout.Y_AXIS));
        back.addActionListener(e -> {
            frame.remove(joinPanel);
            frame.add(mainPanel);
            frame.setSize(new Dimension(500,500));
            SwingUtilities.updateComponentTreeUI(frame);
        });
        Client client = new Client(ip,port,clientUserName,this);
        join.addActionListener(e -> {
            field.setEditable(true);
            boolean invP = false;
            boolean invI = false;
            boolean invU = false;
            for(char c: portF.getText().toCharArray()) {
                if(!Character.isDigit(c) || portF.getText().isBlank()) {
                    invP = true;
                }
            }
            if(usernameF.getText().isBlank()) {
                invU = true;
            }
            if(portF.getText().isBlank()) {
                invP = true;
            }
            if(ipF.getText().isBlank()) {
                invI = true;
            }
            for(char c: ipF.getText().toCharArray()) {
                if((!Character.isDigit(c) && c != '.')) {
                    invI = true;
                }
            }
            if(invP) {
                errorPort.setVisible(true);
            }
            if(invI) {
                errorIp.setVisible(true);
            }
            if(invU) {
                errorUser.setVisible(true);
            }
            if((invP || invI || invU)) {
                return;
            }

            port = Integer.parseInt(portF.getText());
            clientUserName = usernameF.getText();
            ip = ipF.getText();

            if(clientFlag) {

            client.setUserName(clientUserName);
            client.setPort(port);
            client.setHostname(ip);
            client.startClient();

            field.setEditable(true);

            connection.setText("Connected to server on:  [" + ip + " : " + port + "]");
            frame.remove(joinPanel);
            frame.remove(hostPanel);
            frame.add(mainPanel);
            frame.setSize(new Dimension(500,500));
            SwingUtilities.updateComponentTreeUI(frame);
            }

        });
        joinMenu.addActionListener(e -> {
            frame.remove(mainPanel);
            frame.remove(hostPanel);
            frame.add(joinPanel);
            frame.setSize(new Dimension(165,350));
            SwingUtilities.updateComponentTreeUI(frame);

        });
    }
    public void host() {
        JLabel usernameL = new JLabel("Username:");
        JLabel ipL = new JLabel("IP:");
        JLabel portL = new JLabel("Port:");
        JButton done = new JButton("Create server");
        JButton back = new JButton("Back");

        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setAlignmentY(Component.CENTER_ALIGNMENT);
        done.setAlignmentX(Component.CENTER_ALIGNMENT);
        done.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel users = new JPanel();
        JPanel ips = new JPanel();
        JPanel ports = new JPanel();

        JTextField portF = new JTextField(10);
        JTextField ipF = new JTextField(10);
        JTextField usernameF = new JTextField(10);

        JLabel errorPort = new JLabel("Invalid port.");
        errorPort.setForeground(Color.RED);
        errorPort.setVisible(false);

        JLabel errorUser = new JLabel("Invalid username.");
        errorUser.setForeground(Color.RED);
        errorUser.setVisible(false);

        JLabel errorIp = new JLabel("Invalid IP.");
        errorIp.setForeground(Color.RED);
        errorIp.setVisible(false);

        hostPanel.add(users);
        hostPanel.add(ips);
        hostPanel.add(ports);
        users.add(usernameL);
        users.add(usernameF);
        users.add(errorUser);
        ips.add(ipL);
        ips.add(ipF);
        ips.add(errorIp);
        ports.add(portL);
        ports.add(portF);
        ports.add(errorPort);
        hostPanel.add(back);
        hostPanel.add(done);

        hostPanel.setBorder(new EmptyBorder(10,10,10,10));

        hostPanel.setLayout(new BoxLayout(hostPanel, BoxLayout.Y_AXIS));
        back.addActionListener(e -> {
            frame.remove(hostPanel);
            frame.remove(joinPanel);
            frame.add(mainPanel);
            frame.setSize(new Dimension(500,500));
            SwingUtilities.updateComponentTreeUI(frame);
        });
        Server server = new Server(port,this);

        done.addActionListener(e -> {
            field.setEditable(true);
            boolean invP = false;
            boolean invI = false;
            boolean invU = false;
            for(char c: portF.getText().toCharArray()) {
                if(!Character.isDigit(c) || portF.getText().isBlank()) {
                    invP = true;
                }
            }
            if(usernameF.getText().isBlank()) {
                invU = true;
            }
            if(portF.getText().isBlank()) {
                invP = true;
            }
            if(ipF.getText().isBlank()) {
                invI = true;
            }

            for(char c: ipF.getText().toCharArray()) {
                if((!Character.isDigit(c) && c != '.')) {
                    invI = true;
                }
            }

            if(invP) {
                errorPort.setVisible(true);
            }
            if(invI) {
                errorIp.setVisible(true);
            }
            if(invU) {
                errorUser.setVisible(true);
            }
            if((invP || invI || invU)) {
                return;
            }

            port = Integer.parseInt(portF.getText());
            clientServerUserName = usernameF.getText();
            ip = ipF.getText();

            server.setPort(port);
            server.setUserName(clientServerUserName);
            server.setIp(ip);
            server.start();

            field.setEditable(true);

            connection.setText("Hosting server on:  [" + ip + " : " + port + "]");

            frame.remove(hostPanel);
            frame.add(mainPanel);
            frame.setSize(new Dimension(500,500));
            SwingUtilities.updateComponentTreeUI(frame);
        });
        host.addActionListener(e -> {
            frame.remove(mainPanel);
            frame.remove(joinPanel);
            frame.add(hostPanel);
            frame.setSize(new Dimension(165,350));
            SwingUtilities.updateComponentTreeUI(frame);

        });
    }
    public void top() {
       topFlow = new JPanel();
       connection.setText("Not connected to any server.");
       topFlow.add(connection);

      mainPanel.add(topFlow, BorderLayout.PAGE_START);
    }
    public void mid() {
        chat.setEditable(false);
        scrollChat = new JScrollPane(chat);

        mainPanel.add(scrollChat, BorderLayout.CENTER);
    }
    public void bot() {
        botFlow = new JPanel(new FlowLayout());

        scrollField = new JScrollPane(field);

        send = new JButton("Send");

        botFlow.add(scrollField);
        botFlow.add(send);

        mainPanel.add(botFlow, BorderLayout.PAGE_END);
    }

    public void setClientFlag(boolean clientFlag) {
        this.clientFlag = clientFlag;
    }
    public JFrame getFrame() {
        return frame;
    }
    public JLabel getConnection() {
        return connection;
    }
    public JTextField getArea() {
       return field;
    }
    public JTextArea getChat() {
        return chat;
    }
}

