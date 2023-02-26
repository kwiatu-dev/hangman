package Interface.Components.Keyboard;

import Interface.Components.Buttons.KeyboardButton;
import Interface.Components.Buttons.PrimaryButton;
import Interface.Components.Containers.Container;
import Views.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Keyboard extends JPanel {
    private View view;
    private KeyboardButton[] letters = new KeyboardButton[26];
    public Keyboard(View view){
        GridLayout grid = new GridLayout(4,7);
        grid.setVgap(2);
        grid.setHgap(2);
        this.setLayout(grid);
        this.view = view;

        for(char c = 'A', i = 0; c <= 'Z'; c++, i++){
            letters[i] = new KeyboardButton(Character.toString(c));
            letters[i].addActionListener(this.view);
            add(letters[i]);
        }

        this.additionalActionButtons();
    }

    public void setPosition(int x, int y){
        this.setBounds(x, y, this.getPreferredSize().width, this.getPreferredSize().height);
    }

    public void setKeyboardSize(int width, int height){
        this.setPreferredSize(new Dimension(width, height));
    }

    public void additionalActionButtons(){
        KeyboardButton reset = new KeyboardButton("Reset");
        KeyboardButton exit = new KeyboardButton("Exit");
        reset.setColor(Color.decode("#eb3434"));
        exit.setColor(Color.decode("#eb3434"));
        reset.addActionListener(this.view);
        exit.addActionListener(this.view);

        add(reset);
        add(exit);
    }

    public KeyboardButton[] getLetters(){
        return this.letters;
    }
}
