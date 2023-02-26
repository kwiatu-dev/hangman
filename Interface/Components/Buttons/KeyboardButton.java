package Interface.Components.Buttons;

import java.awt.*;


public class KeyboardButton extends Button{
    public KeyboardButton(String text){
        super(text);
        this.setBackgroundColor(Color.decode("#14212D"));
        this.setButtonFont("Arial", Font.BOLD, 20);
        this.setColor(Color.WHITE);
        //this.setBorder(null);
    }

    public void resetStyles(){
        this.setBackgroundColor(Color.decode("#14212D"));
        this.setButtonFont("Arial", Font.BOLD, 20);
        this.setColor(Color.WHITE);
    }
}
