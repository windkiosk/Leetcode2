package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://github.com/gzc/oops/blob/master/Google/smashable.cpp
public class Smashable {

    public static void main(String[] args) {
        Smashable smashable = new Smashable();

        String word = "smash";
        String[] strings = {"s", "m", "sm", "a", "sa", "sma", "ma", "s", "as", "ss", "mas", "smas", "sms", "ms", "sas",
                "h", "ssh", "ah", "sash", "smah", "msh", "mh", "sah", "ash", "sh", "mah", "smsh", "smash", "smh",
                "mash"};

        Set<String> dict = new HashSet<>(Arrays.asList(strings));
        Set<String> memo = new HashSet<>();
        System.out.println(smashable.isSmashable(dict, word, memo));
        System.out.println(smashable.isSmashableIterative(dict, word));
    }

    private boolean isSmashable(Set<String> dict, String word, Set<String> memo) {
        if (word.length() == 0 || memo.contains(word)) { return true; }
        if (!dict.contains(word)) { return false; }
        for (int i = 0; i < word.length(); i++) {
            String s0 = word.substring(0, i);
            String s1 = word.substring(i + 1);
            boolean isSmashable = isSmashable(dict, s0 + s1, memo);
            if (!isSmashable) { return false; }
        }
        memo.add(word);
        return true;
    }

    private boolean isSmashableIterative(Set<String> dict, String word) {
        if (!dict.contains(word)) { return false; }

        Set<String> set = new HashSet<>();
        set.add("");

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            String[] list = set.toArray(new String[set.size()]);
            for (String s : list) {
                String newWord = s + c;
                if (dict.contains(newWord)) {
                    set.add(newWord);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
