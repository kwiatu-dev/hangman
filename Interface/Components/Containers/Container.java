package Interface.Components.Containers;

import javax.swing.*;
import java.awt.*;

public class Container extends JLabel {
    public Container(){
        super();
        this.setLayout(null);
    }

    public void setBackgroundImage(ImageIcon background){
        this.setIcon(background);
    }

    public void setBackgroundColor(Color color){
        this.setOpaque(true);
        this.setBackground(color);
    }

    public void setContainerSize(int width, int height){
        this.setPreferredSize(new Dimension(width, height));
    }

    public void setPosition(int x, int y){
        this.setBounds(x, y, this.getPreferredSize().width, this.getPreferredSize().height);
    }
}
