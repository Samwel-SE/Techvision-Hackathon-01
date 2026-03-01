
import java.awt.Graphics2D;



public class Keyboard {


    //adds the numbers to the keyboard
    private final NumberChar[] numbers = new NumberChar[10];
    
    //adds the letters to the keyboard
    private Letter[] letters = new Letter[26];

    //adds some InteractionKeys 
    public InteractionKeys[] InteractionButtons = new InteractionKeys[2];
    

    public void addChars() {

        char[] keyboardLetters = {
        '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
        'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
        'z', 'x', 'c', 'v', 'b', 'n', 'm'};


        //draws the numbers
        for (int i=0; i<10; i++) {
            numbers[i] = new NumberChar(keyboardLetters[i], (60*i)+130, 300);
        } 

        //draws the first 10 letters
        for (int i=0; i<10; i++) {
            letters[i] = new Letter(keyboardLetters[i+10], (60*i)+130, 375);
        }

        //draws the next 9 letters
        for (int i=0; i<9; i++) {
            letters[i+10] = new Letter(keyboardLetters[i+20], (60*i)+150, 450);
        }

        //draws the last 7 letters
        for (int i=0; i<7; i++) {
            letters[i+19] = new Letter(keyboardLetters[i+29], (60*i)+210, 525);
        }
    }

    public void addInteractionKeys(){
        this.InteractionButtons[0] = new InteractionKeys(730, 300, 75, 40, InteractionKeys.Function.BACKSPACE);
        this.InteractionButtons[1] = new InteractionKeys(55, 450, 75, 40, InteractionKeys.Function.CAPS_LOCK);
    }
    


    //draws keyboard and the boxes around stuff
    public void draw(Graphics2D g){
        
        //draws the numbers
        for(NumberChar num : numbers) num.drawChar(g);

        //draws the letters
        for(Letter l : letters) l.drawChar(g);

        for(InteractionKeys i : InteractionButtons) i.draw(g);
    }

    public char checkCollisions(int pX, int pY, int pW, int pH){

        //checks for number key collision
        for(NumberChar num : numbers){ 
            if(num.bottomCollision(pX, pY, pW, pH)) {
                num.animationState = true;
                return num.getCharacter();
            }
            
        }   

        //checks for letter key collision
        for(Letter l : letters){
            if(l.bottomCollision(pX, pY, pW, pH)) {
                l.animationState = true;
                return l.getCharacter();
            }

        
    }

    //hashtag symbol reprents nothing being pressed down
    return '#';
    }
}