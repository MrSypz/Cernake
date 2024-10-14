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
    private long lastFrameTime;
    private float deltaTime;

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
        lastFrameTime = System.currentTimeMillis();
        while (!windowSettings.shouldClose() && isRunning) {
            long currentTime = System.currentTimeMillis();
            deltaTime = (currentTime - lastFrameTime) / 1000.0f;
            lastFrameTime = currentTime;
            input();
            playerSprite.update(deltaTime);

            renderer.clear();

            renderer.renderSprite(playerSprite);

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
//        if (inputHandler.isKeyPressed(GLFW_KEY_W)) {
//            playerSprite.setPosition(playerSprite.getX(), playerSprite.getY() + 1f);
//        }
        if (inputHandler.isKeyPressed(GLFW_KEY_S)) {
            playerSprite.setPosition(playerSprite.getX(), playerSprite.getY() - 1f);
        }
        if (inputHandler.isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
            playerSprite.jump(); // Apply jump force
        }
    }

    private void cleanup() {
        windowSettings.cleanup();
    }
}
