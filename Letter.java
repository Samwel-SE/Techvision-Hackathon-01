
public class Letter extends KeyChar {

    public Letter(char c, int x, int y) {
        super(c, x, y);
    }

    @Override
    public int getCharX() { return this.x; }
    @Override
    public int getCharY() { return this.y; }

    @Override
    public void shift() { this.character = Character.toUpperCase(this.character); }
    @Override
    public void unShift() { this.character = Character.toLowerCase(this.character); }

}
