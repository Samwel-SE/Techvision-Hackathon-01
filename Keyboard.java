
import java.awt.Graphics2D;



public class Keyboard {

    private NumberChar[] numbers = new NumberChar[10];
    private Letter[] letters = new Letter[26];


    public Keyboard(){

    }

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

        //draws the next 10 letters
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


    //draws keyboard and the boxes around stuff
    public void draw(Graphics2D g){

        for(NumberChar num : numbers){
            num.drawChar(g);
        }

        for(Letter l : letters){
            l.drawChar(g);
        }

    }


}