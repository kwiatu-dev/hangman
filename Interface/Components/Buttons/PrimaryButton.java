package Interface.Components.Buttons;

public class PrimaryButton extends Button {

    public PrimaryButton(String text) {
        super(text, 0, 0, 100, 50, false);
    }

    public PrimaryButton(String text, int x, int y) {
        super(text, x, y, 100, 50, false);
    }

    public PrimaryButton(String text, int x, int y, int width, int height) {
        super(text, x, y, width, height, false);
    }

    public PrimaryButton(String text, int x, int y, int width, int height, boolean focusable) {
        super(text, x, y, width, height, focusable);
    }
}
