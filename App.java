import Interface.GUI;
import Views.GamePanel;
import Views.StartScreen;
import Views.View;

public class App {
    public static void main(String[] args) {
        View[] views = {
                new StartScreen(),
                new GamePanel(),
        };

        GUI gui = new GUI();
        gui.registerViews(views);
    }
}

