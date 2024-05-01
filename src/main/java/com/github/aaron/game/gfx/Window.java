package com.github.aaron.game.gfx;

import com.github.aaron.Game;

import javax.swing.*;
import java.awt.*;

public class Window {

    private final JFrame frame;
    private final Dimension size;

    public Window(int width, int height, String title, Game game) {
        size = new Dimension(width, height);
        frame = new JFrame(title);

        frame.setPreferredSize(size);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
    }
}
