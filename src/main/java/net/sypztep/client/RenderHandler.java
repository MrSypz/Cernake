package net.sypztep.client;

import net.sypztep.entity.SpriteEntity;
import org.lwjgl.opengl.GL11;

public class RenderHandler {
    private int windowWidth;
    private int windowHeight;

    public RenderHandler(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }
    public void clear() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }
    public void init() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, windowWidth, windowHeight, 0, -1, 1); // Origin at top-left, y increases down
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }
    public void renderSprite(SpriteEntity sprite) {
        sprite.render();
    }
}