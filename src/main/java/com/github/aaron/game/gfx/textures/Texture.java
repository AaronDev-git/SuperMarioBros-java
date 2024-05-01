package com.github.aaron.game.gfx.textures;

import java.awt.image.BufferedImage;

public class Texture {

    public BufferedImage mario_l, mario_s, boss;
    private final BufferedImage block;

    public Texture() {
        BufferedImageLoader loader = new BufferedImageLoader();

        block = loader.loadImage("/block.png");
        mario_l = loader.loadImage("/marioL.png");
        mario_s = loader.loadImage("/marioS.png");
        boss = loader.loadImage("/goumba.png");

    }

    public BufferedImage getMarioL() {
        return mario_l;
    }

    public BufferedImage getMario_s() {
        return mario_s;
    }
    public BufferedImage getBlock() {
        return block;
    }

    public BufferedImage getBoss() {
        return boss;
    }

    public void setBoss(BufferedImage boss) {
        this.boss = boss;
    }
}
