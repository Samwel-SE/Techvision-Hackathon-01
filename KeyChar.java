import java.awt.*;

public abstract class KeyChar {

    protected char character;
    protected int x, y;
    protected final int length=20;

    public KeyChar(char c, int x, int y) {
        this.character = c;
        this.x = x;
        this.y = y;
    }

    public abstract void shift();
    public abstract void unShift();

    public abstract int getCharX();
    public abstract int getCharY();

    public abstract void drawChar(Graphics2D g);

}