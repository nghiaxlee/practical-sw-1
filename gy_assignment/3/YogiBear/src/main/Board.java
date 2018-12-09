package main;

import models.Element;
import models.GameLogic;
import models.Position;
import res.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Board extends JPanel {
    private double scale;
    private int scaled_size;
    private final int title_size = 32;
    private GameLogic game;
    private Image bear, basket, ranger, tree, hill, empty;

    public Board(GameLogic g) throws IOException
    {
        game = g;
        scale = 1.0;
        scaled_size = (int)(scale * title_size);
        bear = ResourceLoader.loadImage("res/yogibear2.png");
        basket = ResourceLoader.loadImage("res/basket.png");
        ranger = ResourceLoader.loadImage("res/ranger.jpg");
        tree = ResourceLoader.loadImage("res/tree.png");
        hill = ResourceLoader.loadImage("res/hill.png");
        empty = ResourceLoader.loadImage("res/grass00.png");
    }

    public boolean setScale(double scale)
    {
        this.scale = scale;
        scaled_size = (int)(scale * title_size);
        return refresh();
    }

    public boolean refresh()
    {
        Dimension d = new Dimension(game.map.C * scaled_size, game.map.R * scaled_size);
        setPreferredSize(d);
        setMaximumSize(d);
        setSize(d);
        repaint();
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gr = (Graphics2D)g;
        int w = game.map.C;
        int h = game.map.R;
        Position p = game.map.player;
        for(int y = 0; y < h; ++y)
        {
            for(int x = 0; x < w; ++x)
            {
                Image img = null;
                Element e = game.map.grids[y][x];
                switch (e)
                {
                    case BASKET:
                        img = basket;
                        break;
                    case TREE:
                        img = tree;
                        break;
                    case HILL:
                        img = hill;
                        break;
                    case RANGER:
                        img = ranger;
                        break;
                    case EMPTY:
                        img = empty;
                        break;
                }
                if (p.y == x && p.x == y) img = bear;
                if (img == null)
                    continue;
                gr.drawImage(img, x * scaled_size, y * scaled_size, scaled_size, scaled_size, null);
            }
        }
    }
}
