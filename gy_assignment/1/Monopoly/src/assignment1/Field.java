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

     * The event depends on the strategy of the player and the type of field which

     * he stepped on.

     * @param player

     * Player whom stepped into this field.

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

