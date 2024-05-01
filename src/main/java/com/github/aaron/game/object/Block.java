package com.github.aaron.game.object;

import com.github.aaron.Game;
import com.github.aaron.game.object.util.ObjectID;

import java.awt.*;

public class Block extends GameObject{
    public Block(float x, float y, float width, float height, int scale) {
        super(x, y, ObjectID.Block, width, height, scale);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Game.getTex().getBlock(), (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) getX(),
                (int) getY(),
                (int) getWidth(),
                (int) getHeight());
    }
}
