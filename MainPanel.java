
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class MainPanel extends JPanel implements KeyListener {

    enum enumCurrTxt { USERNAME, PASSWORD };

    private enumCurrTxt currTxt;
    private Player p1;
    private Keyboard keyboard = new Keyboard();
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton submit = new JButton("Submit");

    private final Timer timer;

    private boolean keyPressed = false;

    private boolean submitted = false;

    public MainPanel() {

        addKeyListener(this);
        setFocusable(true);

        keyboard.addChars();
        keyboard.addInteractionKeys();
        addTextBoxes();

        if (submitted){
            hideTextBoxes();
            
        }

        this.p1 = new Player(100, 550, 10, 10);
        
        // setup timer
        timer = new Timer(15, e -> {
            update();
            repaint();
        });

        timer.start();

        currTxt = enumCurrTxt.valueOf("USERNAME");
    }

    public void addTextBoxes() {
        final Font lblFont = new Font("Trebuchet MS", Font.BOLD, 20);
        final Font txtFont = new Font("Trebuchet MS", Font.PLAIN, 20);
        Dimension dimension = new Dimension(300, 30);

        JPanel txtPanel = new JPanel();
        txtPanel.setLayout(new FlowLayout());
        txtPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        JPanel usernameRow = new JPanel();
        JPanel passwordRow = new JPanel();

        // Username row
        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setFont(lblFont);
        username.setFont(txtFont);
        username.setPreferredSize(dimension);
        username.setFocusable(false);
        usernameRow.setLayout(new FlowLayout());
        usernameRow.add(lblUsername);
        usernameRow.add(username);

        // Password row
        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setFont(lblFont);
        password.setFont(txtFont);
        password.setPreferredSize(dimension);
        password.setFocusable(false);
        passwordRow.setLayout(new FlowLayout());
        passwordRow.add(lblPassword);
        passwordRow.add(password);


        txtPanel.add(usernameRow);
        txtPanel.add(passwordRow);
        txtPanel.setOpaque(false);

        //submit.setEnabled(false);
        submit.setFocusable(false); 
        submit.setRequestFocusEnabled(false); 
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);

        submit.addMouseListener(new MouseAdapter() {
          @Override
             public void mousePressed(MouseEvent e) { // ignore all mouse presses
           }
           @Override
             public void mouseReleased(MouseEvent e) { // ignore all mouse releases
            }
         });

        topPanel.add(txtPanel);
        topPanel.add(submit);
        topPanel.setOpaque(false);

        add(topPanel);
    }

 public void hideTextBoxes() {
    if (submitted) {
        username.setVisible(false);
        password.setVisible(false);
        submit.setVisible(false);

        if (username.getParent() != null) {
            username.getParent().setVisible(false);
        }
        if (password.getParent() != null) {
            password.getParent().setVisible(false);
        }
        
        Container parent = submit.getParent();
        if (parent instanceof JPanel) {
            parent.setVisible(false);
        }

        revalidate();
        repaint();
    }
}

    public void submitMessage(Graphics g){
        String user = username.getText();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
        g.drawString("Welcome, " + user, 350, 100);
    }

    public void addCharUsername(char c) {
        if (!(c == '#')) {
            keyPressed = true;
            String currString = username.getText();
            String newString = currString + String.valueOf(c);
            username.setText(newString);
            p1.jumping = false;
        }
    }

    public void removeCharUsername() {
        String currString = username.getText();
        int strLength = currString.length();
        if (!(strLength == 0)) {
           String newString = currString.substring(0, strLength-1);
           username.setText(newString);
        }
    }

    public void addCharPass(char c) {
        if (!(c == '#')) {
            char[] currPassword = password.getPassword();
            char[] newPassword = Arrays.copyOf(currPassword, currPassword.length + 1);
            newPassword[newPassword.length - 1] = c;

            password.setText(new String(newPassword));
            Arrays.fill(currPassword, '\0');
            
            p1.jumping = false;
        }
    }

    public void removeCharPass() {
        char[] currPassword = password.getPassword();
        int passLength = currPassword.length;
        if (!(passLength == 0)) {
          char[] newPassword = Arrays.copyOf(currPassword, passLength- 1);
          password.setText(new String(newPassword));
          Arrays.fill(currPassword, '\0');
        }
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        p1.drawPlayer(g2);
        keyboard.draw(g2);


        //draws the ground and walls
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(0, 610, 1500, 100); //ground floor
        g2.fillRect(0, 0, 20, 1000); //left wall
        g2.fillRect(960, 0, 100, 1000); //right wall
        g2.fillRect(0, 0, 1000, 20); //ceiling

        //draws the platforms around the keyboard
        g2.setColor(Color.BLACK);

        g2.fillRect(55, 530, 800, 5); //bottom platform
        
        g2.fillRect(55, 440, 800, 5); //middle platform

        g2.fillRect(55, 360, 800, 5); // 2nd middle platform

        //writes legend text to screen
        g2.setColor(Color.WHITE);
        g.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
        g2.drawString("Use WASD to move", 400, 650);
    }

    
    

    @Override
    public void keyTyped(KeyEvent e){ /* not used*/ }


    //checks if the player has pressed any keys
    @Override
    public void keyPressed(KeyEvent e){
        p1.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e){
        p1.keyReleased(e);
    }


    public void update() {
        p1.movement();
        p1.collisionWithGroundAndWalls();
        
        Rectangle usernameLclBounds = username.getBounds();
        Rectangle usernameGlblBounds = SwingUtilities.convertRectangle(username.getParent(), usernameLclBounds, this);

        if (p1.checkCollision(usernameGlblBounds.x, usernameGlblBounds.y, usernameGlblBounds.width, usernameGlblBounds.height)) {
            currTxt = enumCurrTxt.valueOf("USERNAME");
        } else {
            Rectangle passwordLclBounds = password.getBounds();
            Rectangle passwordGlblBounds = SwingUtilities.convertRectangle(password.getParent(), passwordLclBounds, this);

            if (p1.checkCollision(passwordGlblBounds.x, passwordGlblBounds.y, passwordGlblBounds.width, passwordGlblBounds.height)) {
                currTxt = enumCurrTxt.valueOf("PASSWORD");
            }
        }

        this.addCharUsername(keyboard.checkCollisions(p1.x, p1.y, p1.width, p1.height));
    }
}