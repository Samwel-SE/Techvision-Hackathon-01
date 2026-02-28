import java.awt.*;

public class Letter {

    private char letter;
    private int x, y;
    private final int length=20;

    public Letter(char c, int x, int y) {
        this.letter = c;
        this.x = x;
        this.y = y;
    }

    public int getLetterX() { return this.x; }
    public int getLetterY() { return this.y; }

    public void capitalise() { this.letter = Character.toUpperCase(this.letter); }
    public void deCapitalise() { this.letter = Character.toLowerCase(this.letter); }

    public void drawLetter(Graphics2D g){
        g.setColor(Color.BLACK);
        // JLabel lbl = new JLabel(char);
        g.drawRect(this.x, this.y, length, length);
    }   
}