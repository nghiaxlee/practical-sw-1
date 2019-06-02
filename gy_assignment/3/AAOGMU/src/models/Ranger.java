// Le Minh Nghia
//
// AAOGMU
//
// Yogi Bear
//
// 2018/12/10 09:50:32
//
// This solution was submitted and prepared by Le Minh Nghia, AAOGMU for the
// Yogi Bear assignment of the Practical software engineering I. course.
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

package models;

public class Ranger {
    public Position pos;
    public boolean moveHorizontal;
    public Direction dir;
    private int diameter;

    public Ranger(Position pos, boolean moveHorizontal)
    {
        this.pos = pos;
        this.moveHorizontal = moveHorizontal;
        if (moveHorizontal)
            dir = Direction.LEFT;
        else
            dir = Direction.DOWN;
//        this.diameter = diameter;
    }

    public void changeDir()
    {
        if (dir == Direction.DOWN)
            dir = Direction.UP;
        else if (dir == Direction.UP)
            dir = Direction.DOWN;
        if (dir == Direction.LEFT)
            dir = Direction.RIGHT;
        else if (dir == Direction.RIGHT)
            dir = Direction.LEFT;
    }
}
