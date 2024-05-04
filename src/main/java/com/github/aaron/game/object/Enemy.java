package com.github.aaron.game.object;

import com.github.aaron.Game;
import com.github.aaron.game.object.util.Handler;
import com.github.aaron.game.object.util.ObjectID;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject{
    private static final float WIDTH = 32;
    private static final float HEIGHT = 32;
    private int health = 2;
    private final BufferedImage sprite;

    private final Handler handler;

    public Enemy(float x, float y, int scale, Handler handler) {
        super(x, y, ObjectID.Enemy, WIDTH, HEIGHT, scale);
        this.handler = handler;
        sprite = Game.getTex().getBoss();
    }

    @Override
    public void tick() {
        setX(getVelX() + getX());
        setY(getVelY() + getY());
        applyGravity();
        collision();
        if (health == 0) {
            handler.removeObj(this);
        }
    }

    private void runAnimation(Graphics g, String path) {
        g.drawImage(sprite, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
    }

    private void collision() {
        for (int i = 0; i < handler.getGameObjects().size(); i ++) {
            GameObject temp = handler.getGameObjects().get(i);

            if (temp.getId() == ObjectID.Block || temp.getId() == ObjectID.Pipe) {
                if (getBounds().intersects(temp.getBounds())) {
                    setY(temp.getY() - getHeight());
                    setVelY(0);

                }
                if (getBoundsTop().intersects(temp.getBounds())) {
                    setY(temp.getY() + temp.getHeight());
                    setVelY(0);
                }
                if (getBoundsRight().intersects(temp.getBounds())) {
                    setX(temp.getX() - getWidth());
                }

                if (getBoundsLeft().intersects(temp.getBounds())) {
                    setX(temp.getX() + temp.getWidth());
                }
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) (getX() + getWidth()/2 - getWidth()/4),
                (int) (getY() + getHeight()/2),
                (int) getWidth()/2,
                (int) getHeight()/2);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle((int) (getX() + getWidth()/2 - getWidth()/4),
                (int) getY(),
                (int) getWidth()/2,
                (int) getHeight()/2);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int) (getX() + getWidth() - 5),
                (int) getY() + 5,
                5,
                (int) getHeight() - 10);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int) getX(),
                (int) (getY() + 5),
                5,
                (int) (getHeight() - 10));
    }

    private void showBounds(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.RED);
        g2d.draw(getBounds());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsTop());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
