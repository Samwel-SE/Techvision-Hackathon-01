
import java.awt.Color;
import java.awt.Graphics2D;



public class InteractionKeys {
    
    enum Function {
        BACKSPACE,
        CAPS_LOCK,
        NONE
    }

    public int x;
    public int y;
    public int width;
    public int height;

    public Function func;

    public boolean animationState;

    public InteractionKeys(int x, int y, int width, int height, Function func){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.func = func;
        this.animationState = false;
    }

    //checks for collision with other objects
    public boolean checkCollision(
        int ObjectX, int ObjectY, int ObjectWidth, int ObjectHeight){
        
        return this.x < ObjectX + ObjectWidth &&
               this.x +this.width > ObjectX &&
               this.y < ObjectY + ObjectHeight &&
               this.y + this.height > ObjectY;
                     
    }

    //draws the buton and text
    public void draw(Graphics2D g2){

        //draws key shadow
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(this.x, this.y, this.width, this.height+6);

        //draws the key box
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(this.x, this.y, this.width, this.height);

        //draws the text in the key
        g2.setColor(Color.WHITE);
        g2.drawString(this.func.toString(), this.x +10, this.y+25);
    }

}