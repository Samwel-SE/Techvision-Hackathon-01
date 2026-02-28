
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
        final Font lblFont = new Font("Arial", Font.BOLD, 32);
        final Font txtFont = new Font("Arial", Font.PLAIN, 32);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JPanel usernameRow = new JPanel();
        JPanel passwordRow = new JPanel();

        // Username row
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(lblFont);
        JTextField username = new JTextField(20);
        username.setFont(txtFont);
        username.setFocusable(false);
        usernameRow.setLayout(new FlowLayout());
        usernameRow.add(lblUsername);
        usernameRow.add(username);


        // Password row
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(lblFont);
        JPasswordField password = new JPasswordField(20);
        password.setFont(txtFont);
        password.setFocusable(false);
        passwordRow.setLayout(new FlowLayout());
        passwordRow.add(lblPassword);
        passwordRow.add(password);

        topPanel.add(usernameRow);
        topPanel.add(passwordRow);

        add(topPanel);
    }

    public void addChars() {

        char[] keyboardLetters = {
        '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
        'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
        'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        char[] numComplements = {'!', '"', 'p', '$', '%', '^', '&', '*', '(', ')'};

        //draws the numbers
        for (int i=0; i<10; i++){
            characters[i] = new NumberChar(keyboardLetters[i], numComplements[i], (60*i)+130, 300);
        } 

        //draws the next 10 letters
        for (int i=0; i<10; i++) {
            characters[i+10] = new Letter(keyboardLetters[i+10], (60*i)+130, 375);
        }

        //draws the next 9 letters
        for(int i=0; i<9; i++){
            characters[i+20] = new Letter(keyboardLetters[i+20], (60*i)+150, 450);
        }

        //draws the last 7 letters
        for(int i=0; i<7; i++){
            characters[i+29] = new Letter(keyboardLetters[i+29], (60*i)+210, 525);
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