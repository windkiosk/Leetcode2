package leetcode.problems.algorithms;

public class BinarySearch {

    public static void main(String[] strings) {
        System.out.println(binarySearch(new int[]{1}, 2));
        System.out.println(binarySearch(new int[]{1, 2, 5}, 3));
        System.out.println(binarySearch(new int[]{1, 2, 6, 8, 10, 12, 45, 78}, 11));
        System.out.println(binarySearch(new int[]{1, 2, 6, 8, 10, 12, 45, 78}, 12));
    }

    public static int binarySearch(int[] arrays, int key) {
        int low = 0;
        int high = arrays.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int mid_val = arrays[mid];
            if (key > mid_val) {
                low = mid + 1;
            } else if (key < mid_val) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return - (low + 1);
    }
}
