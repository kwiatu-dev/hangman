package Interface.Components.Images;

import javax.swing.*;

public class Image extends JLabel {
    public Image(ImageIcon image){
        super();
        this.setIcon(image);
    }

    public void setPosition(int x, int y){
        this.setBounds(x,y, this.getPreferredSize().width, this.getPreferredSize().height);
    }

    public void updateImage(ImageIcon image){
        this.setIcon(image);
        this.setPosition(this.getX(), this.getY());
    }
}
