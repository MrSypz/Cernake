package net.sypztep.client;

import net.sypztep.entity.SpriteEntity;
import org.lwjgl.glfw.GLFW;

import static org.lwjgl.glfw.GLFW.*;

public class Cernake {
    private WindowSettings windowSettings;
    private RenderHandler renderer;
    private InputHandler inputHandler;
    private SpriteEntity playerSprite;
    private boolean isRunning;
    public static Cernake cernake = new Cernake();

    public Cernake() {
        windowSettings = new WindowSettings("Cernake Engine", 1920, 1080);
        renderer = new RenderHandler(1920,1080);
        isRunning = true;
    }

    public void start() {
        windowSettings.init();
        inputHandler = new InputHandler(windowSettings.getWindow());
        init();
        loop();
        cleanup();
    }
    public void init() {
        renderer.init();
        playerSprite = new SpriteEntity("player", 0, 0, 200, 200);
    }

    private void loop() {
        while (!windowSettings.shouldClose() && isRunning) {
            // Input handling
            input();

            // Clear and render
            renderer.clear();
            renderer.renderSprite(playerSprite);  // Render the sprite using the RenderHandler

            // Update window
            windowSettings.update();
        }
    }

    private void input() {
        if (inputHandler.isKeyPressed(GLFW.GLFW_KEY_ESCAPE)) {
            isRunning = false;
        }
        if (inputHandler.isKeyPressed(GLFW_KEY_A)) {
            playerSprite.setPosition(playerSprite.getX() -1f, playerSprite.getY());
        }
        if (inputHandler.isKeyPressed(GLFW_KEY_D))
            playerSprite.setPosition(playerSprite.getX() + 1f, playerSprite.getY());
        if (inputHandler.isKeyPressed(GLFW_KEY_W)) {
            playerSprite.setPosition(playerSprite.getX(), playerSprite.getY() - 1f);
        }
        if (inputHandler.isKeyPressed(GLFW_KEY_S)) {
            playerSprite.setPosition(playerSprite.getX(), playerSprite.getY() + 1f);
        }
    }

    private void cleanup() {
        windowSettings.cleanup();
    }
}
