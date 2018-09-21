package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class P380_InsDeGetRan {


}

class RandomizedSet {

    HashMap<Integer, Integer> hashMap;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!hashMap.containsKey(val)) {
            list.add(val);
            hashMap.put(val, list.size() - 1);
            return true;
        }

        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (hashMap.containsKey(val)) {
            int index = hashMap.get(val);
            int tailVal = list.get(list.size() - 1);
            list.set(index, tailVal);
            list.remove(list.size() - 1);
            hashMap.put(tailVal, index);
            hashMap.remove(val);
            return true;
        }

        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (list.size() > 0) {
            final int index = random.nextInt(list.size());
            return list.get(index);
        } else {
            return -1;
        }
    }
}
