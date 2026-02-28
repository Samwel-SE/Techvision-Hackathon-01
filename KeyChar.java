import java.awt.*;

public abstract class KeyChar {

    protected char character;
    protected int x, y;
    protected final int length=40;

    public KeyChar(char c, int x, int y) {
        this.character = c;
        this.x = x;
        this.y = y;
    }

    public int getCharX() { return this.x ;}
    public int getCharY() { return this.y; }

    public void drawChar(Graphics2D g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(this.x + 5, this.y + 5, length, length);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.x, this.y, length, length);
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, length, length);

        String text = String.valueOf(this.character);

        final int OFFSET = 4;

        int textX = (this.x + (length / 2)) - OFFSET;
        int textY = (this.y + (length / 2)) + OFFSET;

        g.setColor(Color.WHITE);
        g.setFont(new Font("Impact", Font.PLAIN, 12));
        g.drawString(text, textX, textY);
    }

}