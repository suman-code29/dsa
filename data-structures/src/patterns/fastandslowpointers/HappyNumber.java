package patterns.fastandslowpointers;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int findSquare(int val) {
        int sum = 0;
        int digit = 0;

        while(val > 0) {
            digit = val % 10;
            sum += digit * digit;
            val /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(23));
        System.out.println(happyNumber.isHappy(12));
    }
}
