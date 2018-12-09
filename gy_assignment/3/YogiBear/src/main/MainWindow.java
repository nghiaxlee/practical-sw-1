package main;

import models.Direction;
import models.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainWindow extends JFrame{
    private final GameLogic game;
    private Board board;
    private final JLabel gamePoint;

    public MainWindow() throws IOException
    {
        game = new GameLogic();
        setTitle("Yogi Bear");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("Game");
        JMenuItem itemNew = new JMenuItem(new AbstractAction("New game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.newGame();
                refreshGamePoint();
                board.refresh();
                pack();
            }
        });
        JMenu menuGameScale = new JMenu("Zoom");
        createScaleMenuItems(menuGameScale, 1.0, 2.0, 0.5);

        JMenuItem menuGameExit = new JMenuItem(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuGame.add(itemNew);
        menuGame.add(menuGameScale);
        menuGame.addSeparator();
        menuGame.add(menuGameExit);
        menuBar.add(menuGame);
        setJMenuBar(menuBar);

        setLayout(new BorderLayout(0, 10));
        try {
            add(board = new Board(game), BorderLayout.CENTER);
        } catch (IOException ex) {}

        gamePoint = new JLabel("Nghia Le");
        add(gamePoint, BorderLayout.NORTH);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key_code = e.getKeyCode();
                Direction d = null;
                switch (key_code)
                {
                    case KeyEvent.VK_LEFT:
                        d = Direction.LEFT;
                        break;
                    case KeyEvent.VK_UP:
                        d = Direction.UP;
                        break;
                    case KeyEvent.VK_DOWN:
                        d = Direction.DOWN;
                        break;
                    case KeyEvent.VK_RIGHT:
                        d = Direction.RIGHT;
                        break;
                    case KeyEvent.VK_ESCAPE:
                        game.restart();
                        break;
                }
                if (d != null && game.step(d))
                {
                    if (game.isEnd())
                    {

                    }
                    else
                    {
                        game.map.moveRanger();
                        game.map.checkCollide();
                    }
                }
                refreshGamePoint();
                board.repaint();
            }
        });

        setResizable(false);
        //setLocationRelativeTo(null);
        board.setScale(2.0);
        pack();
        refreshGamePoint();
        setVisible(true);
    }

    private void refreshGamePoint()
    {
        String s = "Level: " + game.level;
        s += "  Points: " + game.map.point + "/" + game.map.num_basket;
        s += "  Life: " + game.map.life;
        gamePoint.setText(s);
    }

    private void createScaleMenuItems(JMenu menu, double from, double to, double by)
    {
        while (from <= to)
        {
            final double scale = from;
            JMenuItem item = new JMenuItem(new AbstractAction(from + "x") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (board.setScale(scale)) pack();
                }
            });
            menu.add(item);

            if (from == to)
                break;
            from += by;
            if (from > to)
                from = to;
        }
    }

    public static void main (String args[])
    {
        try
        {
            new MainWindow();
        }
        catch (IOException ex) { System.out.println("Error"); }
    }
}
