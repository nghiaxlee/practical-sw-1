package assignment1;

import java.util.ArrayList;

public abstract class Player {
    protected String name;
    protected String kind;
    protected int balance;
    protected int pos;
    protected ArrayList<Property> owned;

    public Player(String name, String kind)
    {
        this.name = name;
        this.kind = kind;
        owned = new ArrayList<>();
        balance = 10000;
        pos = 0;
    }

    /**
     * @return
     */
    public boolean stillAlive()
    {
        return balance >= 0;
    }

    /**
     * @param money
     */
    public void pay(int money)
    {
        if (stillAlive())
            balance -= money;
    }

    /**
     * @param money
     */
    public void earn(int money)
    {
        if (stillAlive())
            balance += money;
    }

    /**
     * The decision of one player when stepped on an empty property or his owned property.
     * It depends on the strategy of the player.
     * @param price
     * price for this purchase.
     * @return
     * True if the player decided to buy/upgrade the property else return False.
     */
    public abstract boolean decideToBuy(int price);

    /**
     * @param field
     */
    public void buy(Property field)
    {
        if (field.getOwner() == null)
        {
            pay(Property.AREA_PRICE);
            owned.add(field);
            field.setOwner(this);
            field.setEmpty(true);
            field.setPrice(500);
        }
        else
        {
            pay(Property.HOUSE_PRICE);
            field.setEmpty(false);
            field.setPrice(2000);
        }
    }

    /**
     *
     */
    public void lose()
    {
        for(Property field: owned)
        {
            field.setOwner(null);
        }
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        String s = name;
        s += "\nBalance: " + balance + "\nProperties: " + owned + " ";
        return s;
    }
}
