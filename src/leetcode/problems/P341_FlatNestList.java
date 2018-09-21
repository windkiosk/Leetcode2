package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class P341_FlatNestList {

    public static void main(String[] strings) {
        NestedIteratorGood nestedIteratorGood = new NestedIteratorGood(createList0());
        while (nestedIteratorGood.hasNext()) {
            System.out.println(nestedIteratorGood.next());
        }

        System.out.println("------");

        nestedIteratorGood = new NestedIteratorGood(createList1());
        while (nestedIteratorGood.hasNext()) {
            System.out.println(nestedIteratorGood.next());
        }

        System.out.println("------");

        NestedIterator nestedIterator = new NestedIterator(createList0());
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }

        System.out.println("------");

        nestedIterator = new NestedIterator(createList1());
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }

    static List<NestedInteger> createList0() {
        //[[1,1],2,[1,1]]
        NestedInteger nestedInteger0 = new NestedInteger(1);
        NestedInteger nestedInteger1 = new NestedInteger(1);
        NestedInteger nestedInteger2 = new NestedInteger(2);
        NestedInteger nestedInteger3 = new NestedInteger(1);
        NestedInteger nestedInteger4 = new NestedInteger(1);

        List<NestedInteger> list0 = Arrays.asList(nestedInteger0, nestedInteger1);
        List<NestedInteger> list1 = Arrays.asList(nestedInteger3, nestedInteger4);

        NestedInteger subList0 = new NestedInteger(list0);
        NestedInteger subList1 = new NestedInteger(list1);

        List<NestedInteger> all = Arrays.asList(subList0, nestedInteger2, subList1);
        return all;
    }

    static List<NestedInteger> createList1() {
        // [[],[3]]
        NestedInteger nestedInteger1 = new NestedInteger(3);
        List<NestedInteger> list1 = Arrays.asList(nestedInteger1);

        NestedInteger subList0 = new NestedInteger(new ArrayList<>());
        NestedInteger subList1 = new NestedInteger(list1);

        List<NestedInteger> all = Arrays.asList(subList0, subList1);
        return all;
    }
}


class NestedIteratorGood implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIteratorGood(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}

class NestedIterator implements Iterator<Integer> {

    private Node node;
    private Stack<Node> stack;
    private Integer nextInt;

    private static class Node {
        List<NestedInteger> list;
        int index;

        private Node(List<NestedInteger> list, int index) {
            this.list = list;
            this.index = index;
        }

        NestedInteger get() {
            if (index < list.size()) {
                return list.get(index);
            } else {
                return null;
            }
        }

        void incrementIndex() {
            index ++;
        }

        boolean hasNext() {
            return index < list.size();
        }
    }

    public NestedIterator(final List<NestedInteger> nestedList) {
        node = new Node(nestedList, 0);
        stack = new Stack<>();
        findNext();
    }

    private void findNext() {
        while ((node != null && node.hasNext()) || !stack.isEmpty()) {
            NestedInteger curr = node == null ? null : node.get();
            if (curr == null) {
                node = stack.isEmpty() ? null : stack.pop();
            } else if (curr.isInteger()) {
                node.incrementIndex();
                if (!node.hasNext()) {
                    node = stack.isEmpty() ? null : stack.pop();
                }
                nextInt = curr.getInteger();
                return;
            } else {
                node.incrementIndex();
                if (node.hasNext()) {
                    stack.push(node);
                }
                node = new Node(curr.getList(), 0);
            }
        }
        nextInt = null;
    }

    @Override
    public Integer next() {
        Integer ret = nextInt;
        findNext();
        return ret;
    }

    @Override
    public boolean hasNext() {
        return nextInt != null;
    }

}

class NestedInteger {
    private boolean isInteger;
    private int integer;
    private List<NestedInteger> list;

    NestedInteger(List<NestedInteger> list) {
        this.list = list;
        isInteger = false;
    }

    NestedInteger(int i) {
        isInteger = true;
        integer = i;
    }

    boolean isInteger() {
        return isInteger;
    }

    Integer getInteger() {
        return integer;
    }

    List<NestedInteger> getList() {
        return list;
    }
}
