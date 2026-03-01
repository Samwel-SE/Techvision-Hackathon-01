import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Player implements KeyListener{

    public int x;
    public int y; 
    public int width;
    public int height;

    public boolean movingRight;
    public boolean movingLeft;

    public boolean jumping;


    public int jumpVel;

    final int JUMP_VEL = 13;

    private BufferedImage cursorImage;

    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.jumping = false;
        this.movingRight = false;
        this.movingLeft = false;

        this.jumpVel = JUMP_VEL;  

        try {
            // This looks for 'cursor.png' in your project resources folder
            cursorImage = ImageIO.read(getClass().getResourceAsStream("/cursor.png"));
        } catch (IOException | NullPointerException e) {
            System.out.println("Error: Could not find cursor.png. Check your file path!");
            e.printStackTrace();
        }
    }

    
    @Override
    public void keyTyped(KeyEvent e){ /* does nothing */ }

    //handles when keys are pressed
    @Override
    public void keyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_W){
            this.jumping = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_D) this.movingRight = true;

        if(e.getKeyCode() == KeyEvent.VK_A) this.movingLeft = true;
    }

    //handles when keys are released
    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_D) this.movingRight = false;

        if(e.getKeyCode() == KeyEvent.VK_A) this.movingLeft = false;
     }

    public void movement(){
        
        if(this.jumping){
            this.y -=  this.jumpVel;
            this.jumpVel -= 1;
        }

        else this.y += 5; 


        if(this.movingRight){
            x += 5;
        }
        if(this.movingLeft){
            x -= 5;
        }
    }


    public void collisionWithGroundAndWalls(){

        //checks collision with ground
        if(this.checkCollision(0, 600, 1500, 1000)){
            this.jumping = false;
            this.y = 600;
            this.jumpVel = JUMP_VEL;
        }

        //checks collision with the left wall
        if(this.checkCollision(0, 0, 25, 1000)) this.x = 20;
        
        //checks collision with the right wall
        if(this.checkCollision(950, 0, 100, 1000)) this.x = 950;



    }

    public boolean checkCollision(
        int ObjectX, int ObjectY, int ObjectWidth, int ObjectHeight){
        
        return (this.x >= ObjectX &&
                this.x +this.width <= ObjectX + ObjectWidth) &&
               (this.y >= ObjectY && 
                this.y +this.height <= ObjectY + ObjectHeight);
                     
    }

  public void drawPlayer(Graphics2D g) {
        if (cursorImage != null) {
            // Draw the image scaled to your width and height
            g.drawImage(cursorImage, this.x, this.y, this.width, this.height, null);
        } else {
            // FALLBACK: If image fails to load, draw the black rectangle so the player isn't invisible
            g.setColor(Color.BLACK);
            g.fillRect(this.x, this.y, this.width, this.height);
        }
    }

}
