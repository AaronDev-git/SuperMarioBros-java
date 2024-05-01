package com.github.aaron.game.object.util;

import com.github.aaron.game.object.Boss;
import com.github.aaron.game.object.GameObject;
import com.github.aaron.game.object.Player;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Handler {

    private final List<GameObject> gameObjects;
    private Player player;
    private Boss boss;

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

    public void setBoss(Boss boss) {
        if (this.boss != null) {
            return;
        }

        addObj(boss);
        this.boss = boss;
    }




    public int removePlayer(Player player) {
        if (player == null) {
            return -1;
        }
        removeObj(player);
        this.player = null;
        return 0;
    }

    public Player getPlayer() {
        return player;
    }

    public Boss getBoss() {
        return boss;
    }
}
