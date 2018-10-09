package assignment1;

public class Greedy extends Player{
    public Greedy(String name)
    {
        super(name, "Greedy");
    }

    @Override
    public boolean decideToBuy(int price) {
        return price <= balance;
    }
}
