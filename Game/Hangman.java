package Game;

import Interface.Components.Images.Image;

import javax.swing.*;

public class Hangman {
    private ChallengeLoader challengeLoader = new ChallengeLoader();
    private String category;
    private String word;
    private String letters;
    private int incorrectGuessCount;
    final private ImageIcon[] images = {
            new ImageIcon(Env.IMAGES_DIR + "/Gallows0.gif"),
            new ImageIcon(Env.IMAGES_DIR + "/Gallows1.gif"),
            new ImageIcon(Env.IMAGES_DIR + "/Gallows2.gif"),
            new ImageIcon(Env.IMAGES_DIR + "/Gallows3.gif"),
            new ImageIcon(Env.IMAGES_DIR + "/Gallows4.gif"),
            new ImageIcon(Env.IMAGES_DIR + "/Gallows5.gif"),
            new ImageIcon(Env.IMAGES_DIR + "/Gallows6.gif"),
    };

    private int maxGuesses = images.length;
    private boolean currentRoundState;
    private int gameStatus;

    public Hangman(){
        this.challengeLoader.generateRandomChallenge();
        this.incorrectGuessCount = 0;
        this.word = this.challengeLoader.getWord();
        this.category = this.challengeLoader.getCategory();
        this.letters = this.word.replaceAll("[a-zA-Z]", "_");
    }

    private void incorrectGuess(){
        this.incorrectGuessCount++;
        this.currentRoundState = false;
    }

    private void correctGuess(char c){
        this.currentRoundState = true;

        for(int i = 0; i < this.word.length(); i++){
            if(this.word.charAt(i) == c){
                this.letters = this.letters.substring(0, i) + c + this.letters.substring(i + 1);
            }
        }
    }

    private boolean checkLetter(char c){
        return this.word.contains(Character.toString(c));
    }

    public String getHiddenWord(){
        return this.letters.replaceAll(".", "$0 ");
    }
    public String getCategory(){
        return this.category;
    }

    public void action(char c){
        if(this.getGameStatus() != 0){ return; }

        if(checkLetter(c)){
            correctGuess(c);
        }
        else{
            incorrectGuess();
        }

        checkGameStatus();
    }

    public ImageIcon getImage(){
        if(this.incorrectGuessCount == 0){
            return null;
        }

        if(this.incorrectGuessCount >= this.maxGuesses){
            return this.images[this.maxGuesses - 1];
        }

        return this.images[this.incorrectGuessCount - 1];
    }

    public void checkGameStatus(){
        if(this.maxGuesses == this.incorrectGuessCount){
            this.gameStatus = -1;
        }
        else if(this.maxGuesses > this.incorrectGuessCount && this.word.equalsIgnoreCase(this.letters)){
            this.gameStatus = 1;
        }
        else{
            this.gameStatus = 0;
        }
    }

    public int getGameStatus(){
        return this.gameStatus;
    }

    public boolean getCurrentRoundState(){
        return this.currentRoundState;
    }

    public void reset(){
        this.challengeLoader.generateRandomChallenge();
        this.incorrectGuessCount = 0;
        this.word = this.challengeLoader.getWord();
        this.category = this.challengeLoader.getCategory();
        this.letters = "_".repeat(word.length());
        this.checkGameStatus();
    }

    public String getWord(){
        return this.word;
    }
}
