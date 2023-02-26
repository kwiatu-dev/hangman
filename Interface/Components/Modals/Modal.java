package Interface.Components.Modals;

import javax.swing.*;
import java.awt.*;
import Interface.Components.Containers.Container;
import Views.View;

public class Modal extends JDialog {
    public Modal(View view){
        super();
        this.setResizable(false);
        this.setModal(true);
        this.setLayout(null);
        this.setLocationRelativeTo(view);
    }

    public void setModalTitle(String title){
        this.setTitle(title);
    }

    public void setModalBackground(Color color){
        this.setBackground(color);
    }

    public void setModalSize(int width, int height){
        this.setSize(new Dimension(width, height + 35));
    }

    public void showModal(){
        this.setVisible(true);
    }

    public void hiddeModal(){
        this.setVisible(false);
    }
}
