
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

        char[] keyboardLetters = {
        // Top Row (Numbers and Symbols)
        '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        // Second Row (QWERTY...)
        'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
        // Third Row (ASDF...)
        'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';',
        // Fourth Row (ZXCV...)
        'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        char[] numComplements = {'!', '"', '£', '$', '^', '&', '*', '(', ')'}

        KeyChar letter[] = new KeyChar[42]; 

        for (int i=0; i<10; i++){
            letters[i] = new Letter(keyboardLetters[i], (30*i)+20, 400);
        } 

        for (int i=10; i<42; i++) {
            letters[i] = new Letter(keyboardLetters[i], (30*i)+20, 400);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        p1.drawPlayer(g2);

        for (int i=0; i<42; i++) {
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