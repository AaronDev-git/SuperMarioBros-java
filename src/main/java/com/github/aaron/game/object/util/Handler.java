package com.github.aaron.game.object.util;

import com.github.aaron.game.object.GameObject;
import com.github.aaron.game.object.Player;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Handler {

    private final List<GameObject> gameObjects;
    private Player player;

    public Handler() {
        gameObjects = new LinkedList<>();
    }

    public void tick() {
        for (GameObject object : gameObjects) {
            object.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObject object : gameObjects) {
            object.render(g);
        }
    }

    public void addObj(GameObject object) {
        gameObjects.add(object);
    }

    public void removeObj(GameObject object) {
        gameObjects.remove(object);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setPlayer(Player player) {
        if (this.player != null) {
            return;
        }

        addObj(player);
        this.player = player;
    }


    public void removePlayer(Player player) {
        if (player == null) {
            return;
        }
        removeObj(player);
        this.player = null;
    }

    public Player getPlayer() {
        return player;
    }
}
