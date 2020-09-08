import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld {
    public static void main(String[] args) {
        JFrame frame=new JFrame("test");
        JButton ok_btn=new JButton("OK");
        JPanel panel=new JPanel(new GridLayout());
        JTextArea text =new JTextArea();
        //frame init
        frame.setSize(800,400);
        frame.setVisible(true);
        frame.getContentPane().add(panel);
        //btn action
        //panel
        panel.add(text);
        panel.add(ok_btn);


    }
}
