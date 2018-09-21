package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class P395_LongestSubKRepeat {

    public int longestSubstring(String s, int k) {
        int longest = 0;
        List<String> list = new ArrayList<>();
        list.add(s);

        while (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i ++) {
                String str = list.get(i);
                //for (char c : )
            }
        }
        return longest;
    }
}
