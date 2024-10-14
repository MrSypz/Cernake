package net.sypztep.client.util;

/**
 * @param namespace  The namespace for the identifier
 * @param path  The resource path */
public record Identifier(String namespace, String path) {
    /**
     *
     * @param path ตำแหน่ง ของภาพ <p>ชื่อไฟล์.png</p>
     * @return ตำแหน่งไฟล์
     */
    public static Identifier of(String path) {
        return new Identifier("cernake", path);
    }
}
