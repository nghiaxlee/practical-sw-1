// Le Minh Nghia
//
// AAOGMU
//
// First assignment - exercise number 4
//
// 2018/10/10 18:17:37
//
// This solution was submitted and prepared by Le Minh Nghia, AAOGMU for the
// First assignment - exercise number 4 assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

package assignment1;



import java.util.ArrayList;



/**

 * This class contains the basic properties of one player in the game.

 */

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

     * False if the player went bankrupt else return True.

     */

    public boolean stillAlive()

    {

        return balance >= 0;

    }



    /**

     * @param money

     * The amount which this player has to pay.

     */

    public void pay(int money)

    {

        if (stillAlive())

            balance -= money;

    }



    /**

     * @param money

     * The amount which this player has just earned.

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

     * The process of buying a property (or building a house).

     * @param field

     * The field which is empty or belonged to this player but has not built a house yet.

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

     * When a player lost, all of his owned properties should be free to buy.

     */

    public void lose()

    {

        for(Property field: owned)

        {

            field.setOwner(null);

        }

    }



    /**

     * The player will move according to the number he rolled and since board is circular

     * after the last field will be the first.

     * @param dice

     * the number of steps he should move.

     * @param num_field

     * the number of fields.

     */

    public void updatePos(int dice, int num_field) {

        this.pos = (this.pos + dice) % num_field;

    }



    public int getPos() {

        return pos;

    }



    public int getBalance() {

        return balance;

    }



    @Override

    public String toString() {

        String s = name;

        s += "\nBalance: " + balance + "\nProperties: " + owned + " ";

        return s;

    }

}

