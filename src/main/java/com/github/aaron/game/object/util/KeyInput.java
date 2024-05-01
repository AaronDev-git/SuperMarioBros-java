package com.github.aaron.game.object.util;

import com.github.aaron.Game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private final boolean[] keyDown = new boolean[4];
    private final Handler handler;
    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (key == KeyEvent.VK_Z || key == KeyEvent.VK_UP || key == KeyEvent.VK_SPACE) {
            if (!handler.getPlayer().hasJumped()) {
                handler.getPlayer().setVelY(-15);
                keyDown[0] = true;
                handler.getPlayer().setJumped(true);
            }
        }

        if (key == KeyEvent.VK_Q || key == KeyEvent.VK_LEFT) {
            handler.getPlayer().setVelX(-8);
            keyDown[1] = true;
        }

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            handler.getPlayer().setVelX(8);
            keyDown[2] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_Z || key == KeyEvent.VK_UP || key == KeyEvent.VK_SPACE) {
            keyDown[0] = false;
        }

        if (key == KeyEvent.VK_Q || key == KeyEvent.VK_LEFT) {
            keyDown[1] = false;
        }

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            keyDown[2] = false;
        }

        if (!keyDown[1] || keyDown[2]) {
            handler.getPlayer().setVelX(0);
        }
    }
}
