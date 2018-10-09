package assignment1;

public class Careful extends Player {
    public Careful(String name)
    {
        super(name, "Careful");
    }

    @Override
    public boolean decideToBuy(int price) {
        return price * 2 <= balance;
    }
}
