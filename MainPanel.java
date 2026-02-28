
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel implements KeyListener {

    private Player p1;
    private Keyboard keyboard = new Keyboard();

    private final Timer timer;


    public MainPanel() {

        addKeyListener(this);
        setFocusable(true);

        keyboard.addChars();
        addTextBoxes();

        this.p1 = new Player(100, 100, 10, 10);
        
        // setup timer
        timer = new Timer(15, e -> {
            update();
            repaint();
        });

        timer.start();
    }

    public void addTextBoxes() {
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        p1.drawPlayer(g2);
        keyboard.draw(g2);


        //draws ground and walls
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(0, 610, 1500, 100);
        g2.fillRect(0, 0, 20, 1000);
        g2.fillRect(960, 0, 100, 1000);
        g2.fillRect(0, 0, 1000, 20);

        //writes legend text to screen
        g2.setColor(Color.BLACK);
        g2.drawString("USE W A S D TO MOVE", 300, 650);
    }

    
    @Override
    public void keyReleased(KeyEvent e){/* not used */ }

    @Override
    public void keyTyped(KeyEvent e){ /* not used*/ }


    //checks if the player has pressed any keys
    @Override
    public void keyPressed(KeyEvent e){
        p1.keyPressed(e);
    }

    public void update(){
        p1.jump();
        p1.collisionWithGroundAndWalls();
    }
}