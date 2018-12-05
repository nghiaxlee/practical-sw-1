// Le Minh Nghia
//
// AAOGMU
//
// 2nd Assignment - Tricky 5-in-a-row
//
// 2018/11/18 14:14:19
//
// This solution was submitted and prepared by Le Minh Nghia, AAOGMU for the
// 2nd Assignment - Tricky 5-in-a-row assignment of the Practical software engineering I. course.
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

import util.MyPair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindow extends CanvasWindow {

    private final int size;
    private final TicTacToe game;
    private final JLabel label;
    private JButton[][] gridButtons;

    public GameWindow(int size) {
        this.size = size;
        game = new TicTacToe(size);
        label = new JLabel();
        gridButtons = new JButton[size][size];
        updateLabelText();

        JPanel top = new JPanel();
        JPanel right = new JPanel();

        JButton newGameButton6 = new JButton();
        newGameButton6.setText("6x6");
        newGameButton6.addActionListener(e -> newGame(6));

        JButton newGameButton10 = new JButton();
        newGameButton10.setText("10x10");
        newGameButton10.addActionListener(e -> newGame(10));

        JButton newGameButton14 = new JButton();
        newGameButton14.setText("14x14");
        newGameButton14.addActionListener(e -> newGame(14));

        top.add(label);

        top.add(newGameButton6);
        top.add(newGameButton10);
        top.add(newGameButton14);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(size, size));

        for(int i = 0; i < size; ++i)
            for(int j = 0; j < size; ++j)
            {
                addButton(mainPanel, i, j);
            }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(right, BorderLayout.EAST);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private void addButton(JPanel panel, final int i, final int j)
    {
        final JButton button = new JButton();
        button.addActionListener(e ->
            {
                char player = game.getName(game.getPlayer());
                ArrayList<MyPair<Integer, Integer>> deleted = game.step(i, j);
                char cur_player = game.getName(game.getPlayer());
                if (cur_player != player)
                {
                    // Meaning you clicked on an empty cell.
                    button.setText("" + player);
                    for(MyPair<Integer, Integer> p: deleted)
                    {
                        System.out.println(p);
                        gridButtons[p.first][p.second].setText("");
                    }

                    updateLabelText();

                    if (game.getWinner() != -1)
                    {
                        showGameOver();
                    }
                }
            }
        );
        panel.add(button);
        gridButtons[i][j] = button;
    }

    private void showGameOver()
    {
        JOptionPane.showMessageDialog(this,
                "Game is over. Winner: " + game.getName(game.getWinner()));
        newGame(size);
    }

    private void updateLabelText()
    {
        label.setText("Current player: " + game.getName(game.getPlayer()) + "  ");
    }

    private void newGame(int n)
    {
        GameWindow newWindow = new GameWindow(n);
        newWindow.setLocation(this.getLocation());
        newWindow.setVisible(true);
        this.dispose();
    }
}
