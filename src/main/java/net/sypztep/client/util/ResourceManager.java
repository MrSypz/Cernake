package net.sypztep.client.util;

import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
    private static final Map<Identifier, Texture> textures = new HashMap<>();
    private static final String RESOURCE_PATH = "src/main/resources/";

    public static Texture registerTexture(String fileName) {
        Identifier identifier = Identifier.of(fileName);
        return textures.computeIfAbsent(identifier, id -> TextureLoader.loadTexture(RESOURCE_PATH + id.path() + ".png"));
    }
}
