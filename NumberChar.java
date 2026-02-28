

public class NumberChar extends KeyChar {

    public NumberChar(char c, int x, int y) {
        super(c, x, y);
    }

    public boolean bottomCollision(int pX, int pY, int pW, int pH){
        return (pX >= this.x && pX +pW <= this.x +40) &&
               (pY >= this.y && pY +pH <= this.y +40);
    }


}