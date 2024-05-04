package com.github.aaron.game.gfx.textures;

import java.awt.image.BufferedImage;

public class Texture {

    private final BufferedImage mario_l;
    private final BufferedImage mario_s;
    private final BufferedImage boss;
    private final BufferedImage bush;
    private final BufferedImage background;
    private final BufferedImage cloud;
    private final BufferedImage[] block;

    public Texture() {
        BufferedImageLoader loader = new BufferedImageLoader();

        block = new BufferedImage[2];
        background = loader.loadImage("/gfx/gui/background.png");
        mario_l = loader.loadImage("/gfx/sprites/marioL.png");
        mario_s = loader.loadImage("/gfx/sprites/marioS.png");
        boss = loader.loadImage("/gfx/sprites/goumba.png");
        block[0] = loader.loadImage("/gfx/blocks/block_0.png");
        block[1] = loader.loadImage("/gfx/blocks/block_1.png");
        bush = loader.loadImage("/gfx/blocks/bush_0.png");
        cloud = loader.loadImage("/gfx/blocks/cloud_0.png");

    }

    public BufferedImage getMarioL() {
        return mario_l;
    }

    public BufferedImage getMario_s() {
        return mario_s;
    }
    public BufferedImage[] getBlocks() {
        return block;
    }

    public BufferedImage getBoss() {
        return boss;
    }

    public BufferedImage getBackground() {
        return background;
    }

    public BufferedImage getBush() {
        return bush;
    }

    public BufferedImage getCloud() {
        return cloud;
    }
}
