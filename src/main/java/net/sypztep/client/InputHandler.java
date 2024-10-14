package net.sypztep.client;

import org.lwjgl.glfw.GLFW;

public class InputHandler {
    private long window;

    public InputHandler(long window) {
        this.window = window;
    }

    public boolean isKeyPressed(int keyCode) {
        return GLFW.glfwGetKey(window, keyCode) == GLFW.GLFW_PRESS;
    }

    public boolean isMouseButtonPressed(int button) {
        return GLFW.glfwGetMouseButton(window, button) == GLFW.GLFW_PRESS;
    }

    public double[] getMousePosition() {
        double[] pos = new double[2];
        GLFW.glfwGetCursorPos(window, pos, pos);
        return pos;
    }
}