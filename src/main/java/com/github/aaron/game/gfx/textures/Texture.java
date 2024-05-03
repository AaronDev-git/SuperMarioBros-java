package com.github.aaron.game.gfx.textures;

import java.awt.image.BufferedImage;

public class Texture {

    private final BufferedImage mario_l;
    private final BufferedImage mario_s;
    private final BufferedImage boss;
    private BufferedImage background;
    private final BufferedImage[] block;

    public Texture() {
        BufferedImageLoader loader = new BufferedImageLoader();

        block = new BufferedImage[2];
        mario_l = loader.loadImage("/sprites/marioL.png");
        mario_s = loader.loadImage("/sprites/marioS.png");
        boss = loader.loadImage("/sprites/goumba.png");
        block[0] = loader.loadImage("/blocks/block.png");
        block[1] = loader.loadImage("/blocks/block_wall.png");

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


}
