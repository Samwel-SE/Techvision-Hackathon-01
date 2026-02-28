
import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {

    private int currentX;
    private int currentY;
    private final int SQUARE_LENGTH = 20;

    private final Timer timer;


    public MainPanel() {

        // setup list
        timer = new Timer(1, e -> {
            repaint();
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.fillRect(currentX, currentY, SQUARE_LENGTH, SQUARE_LENGTH);
    }

    public static void main(String[] args) {
        // Not needed
    }



}