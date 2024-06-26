package com.github.aaron.game.util;

import com.github.aaron.game.gfx.textures.BufferedImageLoader;
import com.github.aaron.game.object.*;
import com.github.aaron.game.object.util.Handler;

import java.awt.image.BufferedImage;

public class LevelHandler {

    private final String PARENT_FOLDER = "/gfx/level";

    private final BufferedImageLoader loader;
    private final Handler handler;

    public LevelHandler(Handler handler) {
        this.handler = handler;
        loader = new BufferedImageLoader();
    }

    public void startRendering() {
        loadLevel(PARENT_FOLDER + "/1_1.png");
    }

    public void loadLevel(String levelTilesPath) {
        BufferedImage level = loader.loadImage(levelTilesPath);

        int width  = level.getWidth();
        int height = level.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //                                      alpha      red        green      blue
                //getRGB() -> int (5_4 bytes = 32 bits) 0000 0000, 0000 0000, 0000 0000, 0000 0000
                int pixel = level.getRGB(i, j);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                if (red == 255 && green == 255 && blue == 255) continue;

                if (red == green && red == blue && red == 120) {
                    handler.addObj(new Block(i*16, j*16, 32, 32, 1, 1));
                } else if (green == 255) {
                    handler.setPlayer(new Player(i*16, j*16, 2, handler));
                } else if (blue == red && blue == green && blue == 200) {
                    handler.addObj(new Block(i*16, j*16, 32, 32, 1, 0));
                } else if (red == 255) {
                    handler.addObj(new Enemy(i*16, j*16, 1, handler));
                } else if (blue == 255) {
                    handler.addObj(new Bush(i*16, j*16, 172, 57, 1, 1));
                } else if (blue == 1 && green == 1) {
                    handler.addObj(new Cloud(i*16, j*16, 172, 86, 1, 1));
                }
            }
        }


    }
}
