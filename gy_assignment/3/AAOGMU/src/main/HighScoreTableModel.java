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

package main;

import storage.HighScore;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class HighScoreTableModel extends AbstractTableModel {
    private final ArrayList<HighScore> highScores;
    private final String[] colName = new String[]{"Name", "Level"};

    public HighScoreTableModel(ArrayList<HighScore> h)
    {
        highScores = h;
    }

    @Override
    public int getRowCount() {
        return highScores.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        return colName[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HighScore h = highScores.get(rowIndex);
        if (columnIndex == 0)
            return h.player;
        return h.level;
    }
}
