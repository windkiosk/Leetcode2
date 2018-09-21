package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P139_WordBreak {

    public static void main(String[] args) {
        String[] dict = new String[] {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa"};
        String in = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

//        String[] dict = new String[]{"leet", "code"};
//        String in = "leetcode";

//        String[] dict = new String[]{"cats", "dog", "sand", "and", "cat", "og"};
//        String in = "catsandog";

        P139_WordBreak wordBreak = new P139_WordBreak();
        System.out.println(wordBreak.wordBreakDP(in, Arrays.asList(dict)));
    }

    public boolean wordBreakDP(String in, List<String> wordDict) {
        boolean[] f = new boolean[in.length() + 1];
        f[0] = true;

        for (int i = 1; i <= in.length(); i ++) {
            for (int j = 0; j < i; j ++) {
                String sub = in.substring(j, i);
                f[i] = f[j] && wordDict.contains(sub);
                if (f[i]) break;
            }
        }

        return f[in.length()];
    }

    public boolean wordBreak(String in, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return helper(in, dict, memo);
    }

    private boolean helper(String in, Set<String> dict, Map<String, Boolean> memo) {
        if (in.length() == 0 || dict.contains(in)) return true;
        if (memo.containsKey(in)) {
            System.out.println("hit: " + in);
            return memo.get(in);
        }

        boolean ret = false;
        for (int i = 1; i <= in.length(); i++) {
            String first = in.substring(0, i);
            if (dict.contains(first)) {
                ret = helper(in.substring(i), dict, memo);
                memo.put(in.substring(i), ret);
                if (ret) break;;
            }
        }

        memo.put(in, ret);
        return ret;
    }
}
