import util.MyPair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindow extends CanvasWindow {

    private final int size;
    private final TicTacToe game;
    private final JLabel label;

    public GameWindow(int size) {
        this.size = size;
        game = new TicTacToe(size);
        label = new JLabel();
        updateLabelText();

        JPanel top = new JPanel();

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
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private void addButton(JPanel panel, final int i, final int j)
    {
        final JButton button = new JButton();
        button.addActionListener(e ->
            {
                char player = game.getName(game.getPlayer());
                ArrayList<MyPair<Integer, Integer>> deleted = game.step(i, j);
                button.setText("" + player);
                for(MyPair<Integer, Integer> p: deleted)
                {
                    System.out.println(p);
                    panel.getComponent(p.first * size + p.second);
                    //remButton(panel, p.first, p.second);
                }

                updateLabelText();

                if (game.getWinner() != -1)
                {
                    showGameOver();
                }
            }
        );
        panel.add(button);
    }

    private void remButton(JPanel panel, final int i, final int j)
    {
        final JButton button = new JButton();
        button.setText("");
        panel.add(button);
    }

    private void showGameOver()
    {
        JOptionPane.showMessageDialog(this,
                "Game is over. Winner: " + game.getName(game.getWinner()));
        newGame(size);
    }

    private void updateLabelText()
    {
        label.setText("Current player: " + game.getName(game.getPlayer()));
    }

    private void newGame(int n)
    {
        GameWindow newWindow = new GameWindow(n);
        newWindow.setVisible(true);
        this.dispose();
    }
}
