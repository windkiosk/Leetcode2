package leetcode.problems;

import java.util.Arrays;

public class P46_Permutation {

    public static void main(String[] args) {
        int[] a0 = new int[] {1, 2, 3};
        HeapAlgo heapAlgo = new HeapAlgo();
        heapAlgo.heapPermutation(a0, a0.length);
    }
}

// Heap's algorithm
class HeapAlgo {

    //Generating permutation using Heap Algorithm
    void heapPermutation(int a[], int size) {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1) {
            System.out.println(Arrays.toString(a));
            return;
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1);

            // if size is odd, swap first and last
            // element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }
            // If size is even, swap ith and last
            // element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }
}
