package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class ChallengeLoader {
    private HashMap<String, String[]> challenges = new HashMap<>();
    private ArrayList<String> categories = new ArrayList<>();
    private String category;
    private String word;
    public ChallengeLoader(){
        try{
            BufferedReader r = new BufferedReader(new FileReader(Env.DATA_FILE));

            String line;
            while((line = r.readLine()) != null){
                String[] row = line.split(",");
                this.categories.add(row[0]);
                this.challenges.put(row[0], Arrays.copyOfRange(row, 1, row.length));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void generateRandomChallenge(){
        Random rand = new Random();
        this.category = this.categories.get(rand.nextInt(this.categories.size()));
        int length = this.challenges.get(this.category).length;
        this.word = this.challenges.get(this.category)[rand.nextInt(length)];

    }

    public String getCategory(){
        return this.category.toUpperCase();
    }

    public String getWord(){
        return this.word.toUpperCase();
    }
}
