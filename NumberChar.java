
import java.awt.*;

public class NumberChar extends KeyChar {

    private final char complement;

    public NumberChar(char c, char complement, int x, int y) {
        super(c, x, y);
        this.complement = complement;
    }

    @Override
    public int getCharX() { return this.x; }
    @Override
    public int getCharY() { return this.y; }

    @Override
    public void shift() { this.character = Character.toUpperCase(this.character); }
    @Override
    public void unShift() { this.character = Character.toLowerCase(this.character); }
    
    @Override
    public void drawChar(Graphics2D g){
        g.setColor(Color.BLACK);
        // JLabel lbl = new JLabel(char);
        g.drawRect(this.x, this.y, length, length);
    }   
}