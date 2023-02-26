package Interface.Components.Buttons;

import Interface.Components.Containers.Container;
import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String text){
        this.setText(text);
        this.setFocusable(false);
    }

    public Button(String text, int x, int y, int width, int height, boolean focusable){
        this.setBounds(x, y, width, height);
        this.setText(text);
        this.setFocusable(focusable);
    }

    public void addTo(Container c){
        c.add(this);
    }

    public void setBackgroundColor(Color color){
        this.setOpaque(true);
        this.setBackground(color);
    }

    public void setButtonFont(String font, int weight, int size){
        Font f = new Font(font, weight, size);
        this.setFont(f);
    }

    public void setColor(Color color){
        this.setForeground(color);
    }

    public void setButtonSize(int width, int height){
        this.setPreferredSize(new Dimension(width, height));
    }

    public void setButtonPosition(int x, int y){
        this.setBounds(x, y, this.getPreferredSize().width, this.getPreferredSize().height);
    }
}

