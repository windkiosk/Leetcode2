package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P819_MostCommonWords {

    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>();
        for (String bannedWord : banned) {
            bannedSet.add(bannedWord);
        }

        HashMap<String, Integer> commonMap = new HashMap<>();
//        paragraph = paragraph.toLowerCase();
        int start = -1;
        int l = paragraph.length();
        for (int i = 0; i < l; i ++) {
            char c = paragraph.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (start < 0) {
                    start = i;
                }
            } else {
                if (start >= 0) {
                    String word = paragraph.substring(start, i);
                    addToMap(bannedSet, commonMap, word);
                }
                start = -1;
            }
        }

        if (start >= 0) {
            String word = paragraph.substring(start);
            addToMap(bannedSet, commonMap, word);
        }

        String ret = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : commonMap.entrySet()) {
            if (entry.getValue() > max) {
                ret = entry.getKey();
                max = entry.getValue();
            }
        }

        return ret;
    }

    private void addToMap(HashSet<String> bannedSet, HashMap<String, Integer> commonMap, String word) {
        if (!bannedSet.contains(word)) {
            Integer v = commonMap.get(word);
            if (v == null) {
                v = 0;
            }
            commonMap.put(word, v + 1);
        }
    }

    public static void main(String[] args) {
        P819_MostCommonWords mostCommonWords_819 = new P819_MostCommonWords();
        String input = "Bob hit a ball, the hit BALL flew far after it was hit.";
        System.out.println(mostCommonWords_819.mostCommonWord(input, new String[]{"hit"}));
    }
}
