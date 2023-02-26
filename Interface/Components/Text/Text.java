package Interface.Components.Text;


import javax.swing.*;
import java.awt.*;

public class Text extends JLabel {
    public Text(String text){
        super(text);
    }

    public void textCenter(){
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setPosition(int x, int y){
        this.setBounds(x, y, this.getPreferredSize().width, this.getPreferredSize().height);
    }

    public void setTextSize(int width, int height){
        this.setPreferredSize(new Dimension(width, height));
    }

    public void setTextFont(String font, int weight, int size){
        Font f = new Font(font, weight, size);
        this.setFont(f);
    }

    public void setTextColor(Color color){
        this.setForeground(color);
    }
}
