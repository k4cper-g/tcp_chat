import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("szenkos's Chat");
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.setLayout(new BorderLayout());

        JButton butt = new JButton("Option panel here.");
        JTextArea chat = new JTextArea();
        JScrollPane scroll = new JScrollPane(chat);

        panel.add(butt, BorderLayout.PAGE_START);
        panel.add(scroll, BorderLayout.CENTER);

        JPanel bot = new JPanel();
        bot.setBackground(Color.PINK);

        panel.add(bot, BorderLayout.PAGE_END);

        bot.setLayout(new FlowLayout());


        JTextArea area = new JTextArea(2,30);
        JScrollPane scroll2 = new JScrollPane(area);

        JButton butt2 = new JButton("Send");

        bot.add(scroll2);
        bot.add(butt2);

     //   panel.add(scroll, BorderLayout.PAGE_END);


      //  panel.add(butt2, BorderLayout.PAGE_END);




        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
