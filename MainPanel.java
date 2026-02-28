
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel implements KeyListener {

    private Letter[] letters = new Letter[26];
    public player p1;
    private final Timer timer;


    public MainPanel() {

        addKeyListener(this);
        setFocusable(true);

        addLetters();

        this.p1 = new player(100, 100, 10, 10);
        
        // setup timer
        timer = new Timer(1, e -> {
            repaint();
        });

        timer.start();
    }


    public void addLetters() {

        for (int i=0; i<26; i++) {
            letters[i] = new Letter(keyboardLetters[i], (30*i)+20, 400);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        p1.drawPlayer(g2);

        for (int i=0; i<26; i++) {
           letters[i].drawLetter(g2);
        }
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