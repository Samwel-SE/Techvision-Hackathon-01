

public class InteractionKeys {
    
    enum Function {
        BACKSPACE,
        ENTER,
        CAPS_LOCK
    }


    public int x;
    public int y;
    public int width;
    public int height;

    public Function func;

    public InteractionKeys(int x, int y, int width, int height, Function func){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.func = func;
    }

    //checks for collision with other objects
    public boolean checkCollision(
        int ObjectX, int ObjectY, int ObjectWidth, int ObjectHeight){
        
        return (this.x >= ObjectX &&
                this.x +this.width <= ObjectX + ObjectWidth) &&
               (this.y >= ObjectY && 
                this.y +this.height <= ObjectY + ObjectHeight);
                     
    }

    
}