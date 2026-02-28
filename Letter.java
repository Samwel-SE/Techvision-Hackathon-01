
public class Letter extends KeyChar {

    public Letter(char c, int x, int y) {
        super(c, x, y);
    }

    public void shift() { this.character = Character.toUpperCase(this.character); }
    public void unShift() { this.character = Character.toLowerCase(this.character); }

    public boolean bottomCollision(int pX, int pY, int pW, int pH){
        return (pX >= this.x && pX +pW <= this.x +40) &&
               (pY >= this.y && pY +pH <= this.y +40);
    }

}
