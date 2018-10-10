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
 * One type of strategies.
 * Player will skip every second chance.
 */
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
