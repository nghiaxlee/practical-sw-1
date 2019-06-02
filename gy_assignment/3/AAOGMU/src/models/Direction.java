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

public enum Direction {
    UP(-1, 0), LEFT(0, -1), RIGHT(0, 1), DOWN(1, 0);
//    UP(0, -1), LEFT(-1, 0), RIGHT(1, 0), DOWN(0, 1);

    public final int x, y;

    Direction(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
