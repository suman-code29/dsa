package maths.basic;

public class ReverseInteger {
    public int reverse(int x) {

        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = Math.abs(x);
        }
        long result = 0;
        while(x > 0) {
            int value = x % 10;
            result = (result * 10) + value;
            x = x/10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        if (negative) {
            return (int)-result;
        } else {
            return (int)result;
        }
    }

    public int rev2(int x) {
        long reverse = 0;
        int temp;

        while (x != 0) {
            temp = x % 10;
            reverse = reverse * 10 + temp;
            x = x / 10;

            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int)reverse;
    }

    public static void main(String[] args) {
        ReverseInteger integer = new ReverseInteger();
        System.out.println(integer.reverse(1534236469));
    }
}
