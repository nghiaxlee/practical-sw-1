package assignment1;

public class Property extends Field {
    public static final int AREA_PRICE = 1000;
    public static final int HOUSE_PRICE = 4000;
    private boolean empty;
    private Player owner;

    public Property(int i)
    {
        super(500, i,"Property");
        empty = true;
    }

    @Override
    public void event(Player player) {
        if (owner == null)
        {
            if (player.decideToBuy(AREA_PRICE))
            {
                player.buy(this);
            }
        }
        else if (player != owner)
        {
            player.pay(price);
            owner.earn(price);
        }
        else if (empty)
        {
            if (player.decideToBuy(HOUSE_PRICE))
            {
                player.buy(this);
            }
        }
    }


    public void setOwner(Player player)
    {
        owner = player;
    }

    public Player getOwner()
    {
        return owner;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
