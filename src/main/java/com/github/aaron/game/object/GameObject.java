package com.github.aaron.game.object;

import com.github.aaron.game.object.util.ObjectID;

import java.awt.*;

public abstract class GameObject {
    private float x, y, velX, velY, width, height;
    private final int scale;
    private ObjectID id;

    public GameObject(float x, float y, ObjectID id, float width, float height, int scale) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.width = width * scale;
        this.height = height * scale;
        this.scale = scale;

    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void applyGravity() {
        velY += 0.5f;

    }

    public void kill() {

    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setId(ObjectID id) {
        this.id = id;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public void setWidth(float width) {
        this.width = width * scale;
    }

    public void setHeight(float height) {
        this.height = height * scale;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public ObjectID getId() {
        return id;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
