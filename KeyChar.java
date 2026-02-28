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

    public abstract void shift();
    public abstract void unShift();

    public abstract int getCharX();
    public abstract int getCharY();

    public void drawChar(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, length, length);

        String text = String.valueOf(this.character);

        int textX = this.x + (length / 2);
        int textY = this.y + (length / 2);

        g.drawString(text, textX, textY);
    }

}