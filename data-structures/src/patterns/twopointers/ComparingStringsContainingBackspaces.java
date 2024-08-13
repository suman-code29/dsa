package patterns.twopointers;

public class ComparingStringsContainingBackspaces {
    public static boolean compare(String str1, String str2) {
        String first = solve(str1);
        String second = solve(str2);

        return first.equals(second);
    }

    private static String solve(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '#' && !sb.isEmpty()) {
                sb.setLength(sb.length() - 1); // Remove the last character
            } else if (c != '#') {
                sb.append(c); // Add character if it's not a '#'
            }
        }
        return sb.toString();
    }

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String one = "xywrrmp";
        String two = "xywrrmu#p";

        System.out.println(compare(one, two));
        System.out.println(backspaceCompare(one, two));
    }
}
