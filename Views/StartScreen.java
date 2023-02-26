package Views;

import Game.Env;
import Interface.Components.Buttons.PrimaryButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends View implements ActionListener {
    private PrimaryButton playButton;
    private PrimaryButton exitButton;
    final private ImageIcon background = new ImageIcon(Env.IMAGES_DIR + "/start-screen_background.gif");

    public StartScreen(){
        super();
        build();
    }

    private void build(){
        container.setBackgroundImage(background);
        playButton = new PrimaryButton("Play", 280, 500);
        exitButton = new PrimaryButton("Exit", 420, 500);
        playButton.addTo(container);
        exitButton.addTo(container);
        playButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            CardLayout cardLayout = (CardLayout) panel.getLayout();
            cardLayout.show(panel, "2");
        }

        if (e.getSource() == exitButton) {
            frame.dispose();
        }
    }
}
