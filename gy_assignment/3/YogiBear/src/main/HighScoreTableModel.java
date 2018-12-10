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
