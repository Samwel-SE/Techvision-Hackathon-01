
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel implements KeyListener {

    private Player p1;

    private KeyChar[] characters = new KeyChar[36];
    
    private final Timer timer;


    public MainPanel() {

        addKeyListener(this);
        setFocusable(true);

        addChars();
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

    public void addChars() {

        char[] keyboardLetters = {
        '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
        'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
        'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        char[] numComplements = {'!', '"', 'p', '$', '%', '^', '&', '*', '(', ')'};

        for (int i=0; i<10; i++){
            characters[i] = new NumberChar(keyboardLetters[i], numComplements[i], (60*i)+50, 400);
        } 

        for (int i=10; i<36; i++) {
            characters[i] = new Letter(keyboardLetters[i], (60*i)+50, 450);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        p1.drawPlayer(g2);

        for (int i=0; i<36; i++) {
           characters[i].drawChar(g2);
        }   


        //draws ground and walls
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 610, 1500, 100);
        g2.fillRect(0, 0, 20, 1000);
        g2.fillRect(1340, 0, 100, 1000);

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