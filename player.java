import java.awt.*;
import java.awt.event.*;



public class player implements KeyListener{

    public int x;
    public int y; 
    public int width;
    public int height;
    


    public player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
    }


    @Override
    public void keyReleased(KeyEvent e){
        //does nothing just here to not give an error
    }

    @Override
    public void keyTyped(KeyEvent e){
        //does nothing just here to handle error;
    }

    @Override
    public void keyPressed(KeyEvent e){

        switch(e.getKeyCode()){

            case KeyEvent.VK_W:
                this.y -= 5;

            case KeyEvent.VK_D:
                this.x += 5;
            
            case KeyEvent.VK_A:
                this.x -= 5;

            case KeyEvent.VK_S:
                this.y += 5;

        }
    }

    public void drawPlayer(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(this.x, this.y, this.width, this.height);
    }



}
