package com.github.aaron.game.object;

import com.github.aaron.Game;
import com.github.aaron.game.object.util.ObjectID;

import java.awt.*;

public class Bush extends GameObject {

    public Bush(float x, float y, float width, float height, int scale, int type) {
        super(x, y, ObjectID.Bush, width, height, scale);
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Game.getTex().getBush(), (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
