package net.sypztep.entity;

import net.sypztep.client.util.ResourceManager;
import net.sypztep.client.util.Texture;
import org.lwjgl.opengl.GL11;

public class Sprite {
    protected Texture texture;
    protected float x, y;
    protected float width, height;

    public Sprite(String textureName, float x, float y, float height, float width) {
        this.height = height;
        this.width = width;
        this.y = y;
        this.x = x;
        this.texture = ResourceManager.registerTexture(textureName);
    }

    public Sprite(String textureName, float x, float y) {
        this.texture = ResourceManager.registerTexture(textureName);
        this.width = texture.width();
        this.height = texture.height();
        this.x = x;
        this.y = y;
    }

    public Sprite(String textureName) {
        this.texture = ResourceManager.registerTexture(textureName);
        this.width = texture.width();
        this.height = texture.height();
    }

    public void render() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);  // Enable 2D textures
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture.id());

        GL11.glBegin(GL11.GL_QUADS);
        // Top-left corner
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(x, y);
        // Top-right corner
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(x + width, y);
        // Bottom-right corner
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(x + width, y + height);
        // Bottom-left corner
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(x, y + height);
        GL11.glEnd();

        GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);  // Unbind texture
        GL11.glDisable(GL11.GL_TEXTURE_2D);  // Disable 2D textures when done
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
