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



/**

 * This is one kind of Field which player can purchase.

 */

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

            // This means that if player does not have enough money to pay then he will
            // broke, and the owner will receive all of player's money.

            int tmp = player.getBalance();

            if (tmp >= price)
            {
                tmp = price;
            }

            player.pay(price);

            owner.earn(tmp);

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

