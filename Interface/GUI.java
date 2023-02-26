package Interface;

import javax.swing.*;
import java.awt.*;

import Game.Env;
import Views.View;

public class GUI {
    private JFrame frame;
    private JPanel panel;

    public GUI(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.panel.setLayout(new CardLayout());

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle(Env.DIALOG_TITLE);
        this.frame.setSize(Env.DIALOG_W, Env.DIALOG_H);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.add(panel);
    }

    public void registerViews(View[] views){
        for (View v: views) {
            v.setPanel(this.panel);
            v.setFrame(this.frame);
            this.panel.add(v, Integer.toString(v.getId()));
        }
    }
}
