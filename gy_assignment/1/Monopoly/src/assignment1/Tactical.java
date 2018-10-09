package assignment1;

public class Tactical extends Player {
    private int counter;

    public Tactical(String name)
    {
        super(name, "Tactical");
        counter = 0;
    }

    @Override
    public boolean decideToBuy(int price) {
        if (price <= balance)
        {
            counter = (counter + 1) % 2;
            if (counter == 1)
                return true;
        }
        return false;
    }
}
