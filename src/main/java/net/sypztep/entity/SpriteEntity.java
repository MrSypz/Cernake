package net.sypztep.entity;


public class SpriteEntity extends Sprite {
    private boolean isGravity;
    private float velocityY;
    private static final float GRAVITY = 48f * -9.81f;
    private static final float JUMP_FORCE = 125.0f;
    private static final float FLOOR_Y = 0;

    public SpriteEntity(String textureName, float x, float y, float height, float width) {
        super(textureName, x, y, height, width);
        this.setPosition(x, y);
        this.isGravity = true;
        this.velocityY = 0;
    }
    public void update(float deltaTime) {
        if (isGravity) {
            velocityY += GRAVITY * deltaTime;
            setPosition(getX(), getY() + velocityY * deltaTime);
            if (getY() <= FLOOR_Y) {
                setPosition(getX(), FLOOR_Y);
                velocityY = 0;
            }
        }
    }

    public void jump() {
        if (getY() <= FLOOR_Y) {
            velocityY += JUMP_FORCE;
        }
    }
}