package com.github.aaron;

import java.awt.*;
import java.awt.image.BufferStrategy;

import com.github.aaron.game.gfx.textures.Texture;
import com.github.aaron.game.object.util.Handler;
import com.github.aaron.game.object.util.KeyInput;
import com.github.aaron.game.gfx.Camera;
import com.github.aaron.game.gfx.Window;
import com.github.aaron.game.util.LevelHandler;

public class Game extends Canvas implements Runnable {

    private static final int MILLIS_PER_SEC = 1000;
    private static final int NANOS_PER_SEC = 1000000000;
    private static final double NUM_TICKS = 60.0;
    private static final String NAME = "Super Mario Bros";

    private static final int WINDOW_WIDTH = 960;
    private static final int WINDOWS_HEIGHT = 720;

    private static final int SCREEN_WIDTH = WINDOW_WIDTH - 67;
    private static final int SCREEN_HEIGHT = WINDOWS_HEIGHT;
    private static final int SCREEN_OFFSET = 16*3;

    private static Game instance;


    private boolean running;

    private Thread thread;
    private Handler handler;
    private Camera cam;
    private static final Texture tex = new Texture();;


    public void init() {
        instance = this;
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        LevelHandler levelHandler = new LevelHandler(handler);
        levelHandler.startRendering();



        cam = new Camera(0, SCREEN_OFFSET);
        new Window(WINDOW_WIDTH, WINDOWS_HEIGHT, NAME, this);

        start();
    }

    private synchronized void start() {
        thread = new Thread(this);
        thread.start();

        running = true;
    }

    private synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = NUM_TICKS;
        double ns = NANOS_PER_SEC / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }

            if (running) {
                render();
                frames++;
            }

            if (System.currentTimeMillis() - timer > MILLIS_PER_SEC) {
                timer += MILLIS_PER_SEC;
                updates = 0;
                frames = 0;
            }
        }

        stop();
    }

    private void tick() {
        handler.tick();
        cam.tick(handler.getPlayer());
    }

    private void render() {
        BufferStrategy buf = this.getBufferStrategy();
        if (buf == null) {
            this.createBufferStrategy(3);
            return;
        }
        // draw graphics
        Graphics g = buf.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOWS_HEIGHT);

        g2d.translate(cam.getX(), cam.getY());
        handler.render(g);
        g2d.translate(-cam.getX(), -cam.getY());

        g.dispose();
        buf.show();
    }

    public static int getWindowsHeight() {
        return WINDOWS_HEIGHT;
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }
    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static Texture getTex() {
        return tex;
    }

    public static Game getInstance() {
        return instance;
    }
}
