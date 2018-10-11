package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class P68_TextJustification {

    public static void main(String[] args) {
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to",
                "explain", "to","a","computer.","Art","is","everything","else","we","do"};
//        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        P68_TextJustification textJustification = new P68_TextJustification();
        List<String> strings = textJustification.fullJustify(words, 20);
        System.out.println(strings);
    }

    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }

        return lines;
    }
}
