
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel implements KeyListener {


    private Player p1;
    private final Timer timer;


    public MainPanel() {

        addKeyListener(this);
        setFocusable(true);

        this.p1 = new Player(100, 100, 10, 10);
        
        // setup timer
        timer = new Timer(15, e -> {
            update();
            repaint();
        });

        timer.start();
    }

    //draws all the items in the game
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        p1.drawPlayer(g2);



        //draws the ground and walls of the screen
        g2.setColor(Color.GRAY);
        g2.fillRect(0,610, 1500, 100);
        g2.fillRect(0,0, 20, 1000);
        g2.fillRect(1310, 0, 100, 1000);
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

    //checks for collision between objects and jumping 
    public void update(){
        p1.jump();
        p1.collisionWithGroundAndWalls();
    }


}