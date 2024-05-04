package com.github.aaron.game.gfx;

import com.github.aaron.Game;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(int width, int height, String title, Game game) {
        Dimension size = new Dimension(width, height);
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(size);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

    }

    public void render(Graphics g) {
        g.drawImage(Game.getTex().getBackground(), 0, 0, null);
    }
}
