package house;

public class Window {

    public final int width, height;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public String toString() {
        return "  Window (" + width + "cm x " + height + "cm)";
    }

}
