import java.awt.*;
import javax.swing.*;

public abstract class KeyChar {

    protected char character;
    protected int x, y;
    protected final int length=40;

    private Timer timer;
    public boolean animationState = false;


    public KeyChar(char c, int x, int y) {
        this.character = c;
        this.x = x;
        this.y = y;
    }

    public int getCharX() { return this.x ;}
    public int getCharY() { return this.y; }

    public void drawChar(Graphics2D g) {
        
        if(this.animationState){
            this.Pressed(g);
        }
        else{
            //shadow
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(this.x + 5, this.y + 5, length, length);
            
            
            //key
            g.setColor(Color.DARK_GRAY);
            g.fillRect(this.x, this.y, length, length);

            String text = String.valueOf(this.character);

            final int OFFSET = 4;

            int textX = (this.x + (length / 2)) - OFFSET;
            int textY = (this.y + (length / 2)) + OFFSET;

            g.setColor(Color.WHITE);
            g.setFont(new Font("Impact", Font.PLAIN, 12));
            g.drawString(text, textX, textY);
        }
    }

    public char getCharacter(){
        return this.character;
    }

    public void Pressed(Graphics2D g){
        
        //new shadow
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(this.x + 5, this.y, length, length + 6);
        
        //key
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.x, this.y - 6, length, length);

        //charecter text
        String text = String.valueOf(this.character);

        final int OFFSET = 4;

        int textX = (this.x + (length / 2)) - OFFSET;
        int textY = (this.y + ((length - 6) / 2)) + OFFSET;

        g.setColor(Color.WHITE);
        g.setFont(new Font("Impact", Font.PLAIN, 12));
        g.drawString(text, textX, textY);
        
        
        timer = new Timer(500, e -> {
            this.animationState = false;
        });

        timer.setRepeats(false);
        
        timer.start();

    }

}