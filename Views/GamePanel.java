package Views;

import Game.Env;
import Game.Hangman;
import Interface.Components.Buttons.KeyboardButton;
import Interface.Components.Buttons.PrimaryButton;
import Interface.Components.Containers.Container;
import Interface.Components.Images.Image;
import Interface.Components.Keyboard.Keyboard;
import Interface.Components.Modals.Modal;
import Interface.Components.Text.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GamePanel extends View implements ActionListener {
    final private ImageIcon chalkboard = new ImageIcon(Env.IMAGES_DIR + "/chalkboard.gif");
    private Hangman hangman;
    private Text categoryText;
    private Text hiddenText;
    private Image hangmanImage;
    private Keyboard keyboard;
    private Modal resultModal;
    private Text resultModalTitle;
    private Text resultModalWord;
    private PrimaryButton resultModalButton;
    public GamePanel(){
        super();
        build();
    }

    private void build(){
        resultModalTitle = new Text("");
        resultModalTitle.textCenter();
        resultModalTitle.setTextSize(300, 100);
        resultModalTitle.setPosition(0,0);
        resultModalTitle.setTextFont("Arial", Font.BOLD, 16);
        resultModalTitle.setTextColor(Color.decode("#000000"));
        resultModalTitle.setBackground(Color.decode("#000000"));

        resultModalWord = new Text("");
        resultModalWord.textCenter();
        resultModalWord.setTextSize(300, 50);
        resultModalWord.setPosition(0,50);
        resultModalWord.setTextFont("Arial", Font.BOLD, 12);
        resultModalWord.setTextColor(Color.decode("#000000"));

        resultModalButton = new PrimaryButton("Restart");
        resultModalButton.setButtonSize(300, 75);
        resultModalButton.setButtonPosition(0, 125);
        resultModalButton.addActionListener(this);

        resultModal = new Modal(this);
        resultModal.setModalTitle("Wisielec - Wynik gry");
        resultModal.setModalBackground(Color.decode("#ff0044"));
        resultModal.setModalSize(300, 200);
        resultModal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                resetGame();
            }
        });
        resultModal.add(resultModalButton);
        resultModal.add(resultModalTitle);
        resultModal.add(resultModalWord);

        hangman = new Hangman();

        hangmanImage = new Image(hangman.getImage());
        hangmanImage.setPosition(300,25);

        Container hangmanContainer = new Container();
        hangmanContainer.setContainerSize(Env.DIALOG_W, 250);
        hangmanContainer.setPosition(0,0);
        hangmanContainer.setBackgroundImage(chalkboard);
        hangmanContainer.add(hangmanImage);

        categoryText = new Text(hangman.getCategory());
        categoryText.textCenter();
        categoryText.setTextSize(Env.DIALOG_W, 50);
        categoryText.setPosition(0,0);
        categoryText.setTextFont("Arial", Font.BOLD, 24);
        categoryText.setTextColor(Color.decode("#FFFFFF"));

        Container categoryContainer = new Container();
        categoryContainer.setContainerSize(Env.DIALOG_W, 50);
        categoryContainer.setPosition(0, 250);
        categoryContainer.setBackgroundColor(Color.decode("#FCA311"));
        categoryContainer.add(categoryText);

        hiddenText = new Text(hangman.getHiddenWord());
        hiddenText.textCenter();
        hiddenText.setTextSize(Env.DIALOG_W, 100);
        hiddenText.setPosition(0,0);
        hiddenText.setTextFont("Arial", Font.BOLD, 34);
        hiddenText.setTextColor(Color.decode("#FFFFFF"));

        Container hiddenContainer = new Container();
        hiddenContainer.setContainerSize(Env.DIALOG_W, 100);
        hiddenContainer.setPosition(0, 300);
        hiddenContainer.setBackgroundColor(Color.decode("#eb4034"));
        hiddenContainer.add(hiddenText);

        keyboard = new Keyboard(this);
        keyboard.setKeyboardSize(Env.DIALOG_W, 180);
        keyboard.setPosition(-2, 400);

        container.add(hangmanContainer);
        container.add(categoryContainer);
        container.add(hiddenContainer);
        container.add(keyboard);
    }

    private void markButton(KeyboardButton button, boolean state){
        if(state == true){
            button.setBackgroundColor(Color.decode("#00e861"));
        }
        else{
            button.setBackgroundColor(Color.decode("#e80f00"));
        }

        button.setEnabled(false);
    }

    private void resetMarkedButtons(){
        for (KeyboardButton button: keyboard.getLetters()) {
            button.resetStyles();
            button.setEnabled(true);
        }
    }

    private void clickLetterButton(ActionEvent e){
        KeyboardButton button = (KeyboardButton) e.getSource();
        hangman.action(button.getText().charAt(0));
        markButton(button, hangman.getCurrentRoundState());
        updateGamePanel();
    }

    public void showWinResultModal(){
        resultModalTitle.setText("Wygrałeś!");
        resultModalWord.setText("Znalazłeś rozwiązanie: " + hangman.getWord());
        resultModal.showModal();
    }

    public void showLoseResultModal(){
        resultModalTitle.setText("Niestety, nie udało się...");
        resultModalWord.setText("Poprawne słowo to: " + hangman.getWord());
        resultModal.showModal();
    }

    private void updateGamePanel(){
        resultModal.hiddeModal();
        categoryText.setText(hangman.getCategory());
        hiddenText.setText(hangman.getHiddenWord());
        hangmanImage.updateImage(hangman.getImage());

        if(hangman.getGameStatus() == -1){
            showLoseResultModal();
        }
        else if(hangman.getGameStatus() == 1){
            showWinResultModal();
        }
    }

    private void resetGame(){
        hangman.reset();
        resetMarkedButtons();
        updateGamePanel();
    }

    private void exit(){
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command == "Reset" || command == "Restart"){
            resetGame();
        }
        else if(command == "Exit"){
            exit();
        }
        else if(hangman.getGameStatus() == 0){
            clickLetterButton(e);
        }
    }
}
