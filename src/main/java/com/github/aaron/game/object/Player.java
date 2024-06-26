package com.github.aaron.game.object;

import com.github.aaron.Game;
import com.github.aaron.game.object.util.Handler;
import com.github.aaron.game.object.util.ObjectID;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    private static final float WIDTH = 16;
    private static final float HEIGHT = 32;
    private static int health = 2;
    private boolean invincible = false;
    private boolean jumped = false;
    private final BufferedImage spriteL;
    private final BufferedImage spriteS;

    private final Handler handler;

    public Player(float x, float y, int scale, Handler handler) {
        super(x, y, ObjectID.Player, WIDTH, HEIGHT, scale);
        this.handler = handler;
        spriteL = Game.getTex().getMarioL();
        spriteS = Game.getTex().getMario_s();
    }

    @Override
    public void tick() {
        setX(getVelX() + getX());
        setY(getVelY() + getY());
        applyGravity();

        collision();
    }

    private void runAnimation(Graphics g, String path) {
        g.drawImage(spriteL, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
    }

    @Override
    public void render(Graphics g) {
        if (health == 2) {
            g.drawImage(spriteL, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
        } else if (health == 1) {
            g.drawImage(spriteS, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight() / 2, null);
        }
    }

    private void collision() {
        for (int i = 0; i < handler.getGameObjects().size(); i ++) {
            GameObject temp = handler.getGameObjects().get(i);

            if (temp.getId() == ObjectID.Block || temp.getId() == ObjectID.Pipe) {
                if (getBounds().intersects(temp.getBounds())) { //bas
                    setY(temp.getY() - getHeight());
                    setVelY(0);
                    jumped = false;
                }
                if (getBoundsTop().intersects(temp.getBounds())) { //haut
                    setY(temp.getY() + temp.getHeight());
                    setVelY(0);
                }
                if (getBoundsRight().intersects(temp.getBounds())) { //droite
                    setX(temp.getX() - getWidth());
                }

                if (getBoundsLeft().intersects(temp.getBounds())) { //gauche
                    setX(temp.getX() + temp.getWidth());
                }

            } else if (temp.getId() == ObjectID.Enemy) {
                if (isInvincible()) return;
                Enemy enemy = (Enemy) temp;
                if (getBounds().intersects(temp.getBounds())) {
                    enemy.setHealth(enemy.getHealth() - 1);
                }
                if (getBoundsTop().intersects(temp.getBounds())) {
                    setY(temp.getY() + temp.getHeight());
                    enemy.setHealth(enemy.getHealth() - 1);
                }
                if (health >= 2) {
                    if (getBoundsRight().intersects(temp.getBounds())) {
                        health--;
                        invincible = true;
                    }

                    if (getBoundsLeft().intersects(temp.getBounds())) {
                        health--;
                        invincible = true;
                    }
                } else {
                    if (getBoundsRight().intersects(temp.getBounds())) {
                        health = 2;
                        handler.removePlayer(this);
                    }

                    if (getBoundsLeft().intersects(temp.getBounds())) {
                        health = 2;
                        handler.removePlayer(this);
                    }
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

    public boolean hasJumped() {
        return jumped;
    }

    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public boolean isInvincible() {
        return invincible;
    }
}
