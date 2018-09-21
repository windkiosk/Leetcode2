package leetcode.problems.data;

public class ListNode {
    public int val;
    public ListNode next;

    public static void main(String[] strings) {
        ListNode node = ListNode.fromString("1->1->2->3->3");
        System.out.println(node);
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    //"1->1->2->3->3"
    public static ListNode fromString(String state) {
        if (state == null || state.trim().length() == 0) {
            return null;
        }

        int index = state.indexOf("->");
        int cursor = 0;
        ListNode head = null, last = null;
        if (index < 0) {
            head = new ListNode(Integer.valueOf(state));
        } else {
            while (index != -1) {
                String valStr = state.substring(cursor, index);
                ListNode temp = new ListNode(Integer.valueOf(valStr));
                if (head == null) {
                    head = temp;
                    last = temp;
                } else {
                    last.next = temp;
                    last = temp;
                }
                cursor = index + 2;
                index = state.indexOf("->", cursor);
            }

            if (last != null && cursor < state.length()) {
                String valStr = state.substring(cursor);
                last.next = new ListNode(Integer.valueOf(valStr));
            }
        }

        return head;
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            stringBuilder.append(", ");
            head = head.next;
        }
        return stringBuilder.toString();
    }
}
