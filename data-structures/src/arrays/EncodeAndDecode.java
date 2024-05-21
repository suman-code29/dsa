package arrays;

import java.util.Arrays;
import java.util.List;

public class EncodeAndDecode {
    public static void main(String[] args) {
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
        String str = encodeAndDecode.encode(Arrays.asList("neet", "code", "love", "you"));
        System.out.println(str);

        List<String> strs = encodeAndDecode.decode(str);
        for (String str1 : strs) {
            System.out.println(str1);
        }
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str).append("#");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        return List.of(str.split("#"));
    }
}
