package recursion.medium;

public class StringToIntegerAtoI {
//    public int myAtoi(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        // Trim leading and trailing spaces
//        s = s.trim();
//
//        if (s.length() == 0) {
//            return 0;
//        }
//
//        boolean negative = false;
//        int index = 0;
//
//        // Check for optional sign
//        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
//            negative = s.charAt(index) == '-';
//            index++;
//        }
//
//        long result = 0;
//        while (index < s.length()) {
//            char c = s.charAt(index);
//            if (!Character.isDigit(c)) {
//                break;
//            }
//
//            result = result * 10 + (c - '0');
//
//            // Check for overflow
//            if (!negative && result > Integer.MAX_VALUE) {
//                return Integer.MAX_VALUE;
//            }
//            if (negative && -result < Integer.MIN_VALUE) {
//                return Integer.MIN_VALUE;
//            }
//
//            index++;
//        }
//
//        return negative ? (int) -result : (int) result;
//    }

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }
        boolean negative = false;
        long result = 0;
        if (s.charAt(0) == '-') {
            negative = true;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        if (s.isEmpty()) {
            return 0;
        }
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != ' ') return 0;
        for (int i=0; i<s.length();i++) {
            if (!Character.isDigit(s.charAt(i)) && s.charAt(0) != ' '){
                break;
            } else if (s.charAt(i) == ' ') {
            } else if (s.charAt(i) == '-') {
                negative = true;
            } else if (s.charAt(i) == '+') {
            } else {
                int val = s.charAt(i);
                result = (result * 10) + s.charAt(i)-'0';
            }
        }
        if (!negative && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (negative && -result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return negative ? (int) -result : (int) result;
    }

    public static void main(String[] args) {
        StringToIntegerAtoI stringToIntegerAtoI = new StringToIntegerAtoI();
        System.out.println(stringToIntegerAtoI.myAtoi("  -0012a42"));
    }
}
