package Views;

import Interface.Components.Containers.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract public class View extends JPanel implements ActionListener {
    private static int id = 0;
    protected Container container;
    protected JPanel panel;
    protected JFrame frame;

    public View(){
        super();
        this.create();
    }

    private void create(){
        this.container = new Container();
        this.setLayout(new BorderLayout());
        this.add(this.container);
        View.id++;
    }

    public int getId(){
        return this.id;
    }

    public void setPanel(JPanel panel){
        this.panel = panel;
    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    public void registerModal(JDialog dialog){
        dialog.setLocationRelativeTo(this);
    }

    @Override
    abstract public void actionPerformed(ActionEvent e);
}
