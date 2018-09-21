package leetcode.problems;

import leetcode.problems.data.ListNode;

public class P206_ReverseLinkedList {

    public static void main(String[] strings) {
        ListNode head = ListNode.fromString("1->2->3->4->5");
        ListNode head0 = new ListNode(0);
        P206_ReverseLinkedList reverseLinkedList206 = new P206_ReverseLinkedList();
        System.out.println(reverseLinkedList206.reverseList(head));
        System.out.println(reverseLinkedList206.reverseList(head0));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = last;
            last = curr;
            curr = temp;
        }
        return last;
    }
}
