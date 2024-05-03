package com.github.aaron.game.object;

import com.github.aaron.Game;
import com.github.aaron.game.object.util.ObjectID;

import java.awt.*;

public class Block extends GameObject{
    int type;
    public Block(float x, float y, float width, float height, int scale, int type) {
        super(x, y, ObjectID.Block, width, height, scale);
        this.type = type;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Game.getTex().getBlocks()[type], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) getX(),
                (int) getY(),
                (int) getWidth(),
                (int) getHeight());
    }
}
