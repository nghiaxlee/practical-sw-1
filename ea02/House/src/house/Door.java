package house;

public class Door {

    public final int width, height;

    public Door(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "  Door  (" + width + "cm x " + height + "cm)";
    }

    
}
