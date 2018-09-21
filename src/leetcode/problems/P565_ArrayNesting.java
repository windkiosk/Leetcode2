package leetcode.problems;

public class P565_ArrayNesting {

    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] {5,4,0,3,1,6,2};

        P565_ArrayNesting arrayNesting565 = new P565_ArrayNesting();
        System.out.println(arrayNesting565.arrayNesting(a));
    }
}
