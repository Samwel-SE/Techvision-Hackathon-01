
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel implements KeyListener {


    private player p1;
    private final Timer timer;


    public MainPanel() {

        addKeyListener(this);
        setFocusable(true);

        this.p1 = new player(100, 100, 5, 5);
        
        // setup timer
        timer = new Timer(1, e -> {
            repaint();
        });

        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        p1.drawPlayer(g2);
    }

    @Override
    public void keyReleased(KeyEvent e){/* not used */ }

    @Override
    public void keyTyped(KeyEvent e){ /* not used*/ }

    @Override
    public void keyPressed(KeyEvent e){
        p1.keyPressed(e);
    }


}