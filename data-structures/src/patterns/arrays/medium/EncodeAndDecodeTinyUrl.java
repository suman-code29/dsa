package patterns.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyUrl {

    static Map<String, String> keyMap = new HashMap<>();
    static Map<String, String> valueMap = new HashMap<>();
    static String base = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (!keyMap.containsKey(longUrl)) {
            String hash = base + keyMap.size() + 1;
            keyMap.put(longUrl, hash);
            valueMap.put(hash, longUrl);
        }
        return keyMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (valueMap.containsKey(shortUrl)) {
            return valueMap.get(shortUrl);
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "https://leetcode.com/problems/design-tinyurl";
    }
}
