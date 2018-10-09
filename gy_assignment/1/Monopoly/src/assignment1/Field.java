package assignment1;

public abstract class Field {
    protected int price;
    protected int idx;
    protected String type;

    public Field(int price, int i, String type)
    {
        this.price = price;
        this.idx = i;
        this.type = type;
    }

    /**
     * @param player
     * @return
     */
    public abstract void event(Player player);

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String s = idx + "";
        return s;
    }
}
