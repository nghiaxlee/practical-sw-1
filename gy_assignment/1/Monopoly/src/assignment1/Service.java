package assignment1;

public class Service extends Field {
    public Service(int price, int i)
    {
        super(price, i,"Service");
    }

    @Override
    public void event(Player player) {
        player.pay(this.price);
    }
}
