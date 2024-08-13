package patterns.arrays;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // If flowerbed length is less than n, it's impossible to place n flowers
        if (flowerbed.length < n) return false;

        int i = 0;
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                i += 2;
            } else {
                i++;
            }
        }

        return n == 0;
    }


    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
    }
}
