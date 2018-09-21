package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P488_Zuma {

    public static void main(String[] strings) {
        P488_Zuma zuma488 = new P488_Zuma();
        System.out.println(zuma488.findMinStep("WWRRBBWW", "WRBRW"));
    }

    public int findMinStep(String board, String hand) {
        List<Character> list = new ArrayList<>(board.length());
        for (char c : board.toCharArray()) {
            list.add(c);
        }
        if (hand == null || hand.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('Y',0);
        map.put('B',0);
        map.put('G',0);
        map.put('W',0);
        for (char c : hand.toCharArray()) {
            map.put(c, map.get(c) + 1);
        }
        return find(list, map);
    }

    private int find(List<Character> list, Map<Character, Integer> map) {
        eliminate(list);
        if (list.size() == 0) return 0;
        if (empty(map)) return -1;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i ++) {
            char c = list.get(i);
            count++;
            if (i == list.size() - 1 || list.get(i+1) != c) {
                int missing = 3 - count;
                if (map.get(c) >= missing) {
                    map.put(c, map.get(c) - missing);
                    List<Character> smallerBoard = new ArrayList<>(list);
                    for (int j = 0; j<count; j++) {
                        smallerBoard.remove(i-j);
                    }
                    int smallerFind = find(smallerBoard, map);
                    if ( smallerFind != -1 ) {
                        min = Math.min(smallerFind + missing, min);
                    }
                    map.put(c, map.get(c) + missing);
                }
                count = 0;
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private void eliminate(List<Character> list) {
        int count = 0;
        boolean cleaned = false;
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            count++;
            if (i == list.size() - 1 || list.get(i + 1) != c) {
                if (count >= 3) {
                    for (int j = 0; j < count; j++) {
                        list.remove(i - j);
                    }
                    cleaned = true;
                    break;
                }
                count = 0;
            }
        }
        if (cleaned) {
            eliminate(list);
        }
    }

    private boolean empty(Map<Character,Integer> hand) {
        for (int val : hand.values()) {
            if (val > 0) return false;
        }
        return true;
    }
}
