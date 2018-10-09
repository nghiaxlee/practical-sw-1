package assignment1;

public class Lucky extends Field {
    public Lucky(int price, int i)
    {
        super(price, i,"Lucky");
    }

    @Override
    public void event(Player player) {
        player.earn(this.price);
    }
}
