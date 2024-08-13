package patterns.arrays;

public class DesignHashMap {

    private int[] arr;
    public DesignHashMap() {
        this.arr = new int[1000001];
    }

    public void put(int key, int value) {
        arr[key] = value;
    }

    public int get(int key) {
        if (arr[key] != 0) {
            return arr[key];
        }
        return -1;
    }

    public void remove(int key) {
        arr[key] = -1;
    }
}
