package Game;

public class Env {
    public static final String ASSETS_DIR = ClassLoader.getSystemResource("assets").getPath();
    public static final String IMAGES_DIR = Env.ASSETS_DIR + "/images";
    public static final String DATA_DIR = Env.ASSETS_DIR + "/data";
    public static final String DATA_FILE = Env.DATA_DIR + "/data.txt";
    public static final int DIALOG_W = 800;
    public static final int DIALOG_H = 616;
    public static final String DIALOG_TITLE = "Hangman";
}
