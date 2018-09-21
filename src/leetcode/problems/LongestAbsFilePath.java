package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class LongestAbsFilePath {

    public int lengthLongestPath(String input) {
        List<Integer> levelList = new ArrayList<>();
        levelList.add(0);
        int level = 1;
        int len = 0;
        int max = 0;
        boolean isFile = false;
        for (int i = 0; i < input.length(); i ++) {
            char c = input.charAt(i);
            if (c == '\n') {
                int t_index = i + 1;
                while (input.charAt(t_index) == '\t') {
                    t_index ++;
                }
                int newLevel = t_index - i;
                if (newLevel > level) {
                    if (levelList.size() == level) {
                        levelList.add(0);
                    }
                    levelList.set(level, levelList.get(level - 1) + len);
                } else {
                    if (isFile) {
                        int v = levelList.get(level - 1) + len + level - 1;
                        if (v > max) {
                            max = v;
                        }
                    }
                }
                level = newLevel;
                i = t_index - 1;
                len = 0;
                isFile = false;
            } else {
                len ++;
                if (c == '.') {
                    isFile = true;
                }
            }
        }

        if (isFile) {
            int v = levelList.get(level - 1) + len + level - 1;
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestAbsFilePath longestAbsFilePath = new LongestAbsFilePath();
        System.out.println("dir/subdir2/subsubdir2/file2.ext".length());
        System.out.println("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        System.out.println(longestAbsFilePath.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
