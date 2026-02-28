import java.awt.*;
import java.awt.event.*;



public class Player implements KeyListener{

    public int x;
    public int y; 
    public int width;
    public int height;
    public boolean jumping;
    public int jumpVel;

    final int JUMP_VEL = 15;

    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.jumping = false;
        this.jumpVel = JUMP_VEL;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {/* does nothing */ }
    @Override
    public void keyTyped(KeyEvent e){ /* does nothing */ }

    @Override
    public void keyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_W){
            this.jumping = true;
            this.jump();
        }

        if(e.getKeyCode() == KeyEvent.VK_D) this.x += 5;

        if(e.getKeyCode() == KeyEvent.VK_A) this.x -= 5;
    }


    public void jump(){
        if(this.jumping){
            this.y -=  this.jumpVel;
            this.jumpVel -= 1;
        }

        else this.y += 5; 

        
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

        if(this.checkCollision(1330, 0, 25, 1000)) this.x = 1330;



    }

    public boolean checkCollision(
        int ObjectX, int ObjectY, int ObjectWidth, int ObjectHeight){
        
        return (this.x >= ObjectX &&
                this.x +this.width <= ObjectX + ObjectWidth) &&
               (this.y >= ObjectY && 
                this.y +this.height <= ObjectY + ObjectHeight);
                     
    }

    public void drawPlayer(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(this.x, this.y, this.width, this.height);
    }



}
