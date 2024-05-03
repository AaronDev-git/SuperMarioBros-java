package com.github.aaron.game.object;

import com.github.aaron.game.object.GameObject;
import com.github.aaron.game.object.util.ObjectID;

import java.awt.*;

public class Pipe extends GameObject {

    private final boolean enterable;

    public Pipe(int x, int y, int width, int height, int scale, boolean enterable) {
        super(x, y, ObjectID.Pipe, width, height, scale);
        this.enterable = enterable;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    }

    public boolean isEnterable() {
        return enterable;
    }
}
