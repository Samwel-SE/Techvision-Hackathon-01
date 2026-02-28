import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(MainPanel panel) {
        // Create Window
        setTitle("HACKATHON UI");
        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args){
        // Not needed
    }



}