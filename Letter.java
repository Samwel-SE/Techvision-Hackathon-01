
public class Letter extends KeyChar {

    public Letter(char c, int x, int y) {
        super(c, x, y);
    }

    public void shift() { this.character = Character.toUpperCase(this.character); }
    public void unShift() { this.character = Character.toLowerCase(this.character); }

}
