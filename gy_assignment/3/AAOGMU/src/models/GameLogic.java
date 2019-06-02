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

import storage.Database;
import storage.HighScore;

import java.util.ArrayList;

public class GameLogic {

    public Map map;
    public int level;
    public long startTime;
    private final Database database;

    public GameLogic()
    {
        newGame();
        database = new Database();
//        map.PrintMap();
    }

    public boolean isEnd()
    {
        return map.life == 0;
    }

    public void newGame()
    {
        map = new Map(10, 15);
        level = 1;
        startTime = System.currentTimeMillis();
    }

    public ArrayList<HighScore> getHighScores(){ return database.getHighScores(); }
    public void updateScores(String name)
    {
        database.storeHighScore(name, level - 1);
    }

    public boolean step(Direction d)
    {
        int stepped = map.move(d);
        if (stepped == 0) {
            map = new Map(10, 15);
            level++;
            startTime = System.currentTimeMillis();
        }
        return stepped == 1;
    }
}
