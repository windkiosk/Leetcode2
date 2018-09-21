package leetcode.problems;

import leetcode.problems.data.ListNode;

public class P21_MergeSortedLists {

    public static void main(String[] args) {
        ListNode list1 = ListNode.fromString("1->2->4");
        ListNode list2 = ListNode.fromString("1->3->4");

        P21_MergeSortedLists mergeSortedLists = new P21_MergeSortedLists();
        System.out.println(mergeSortedLists.mergeTwoLists(list1, list2));
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }
        return head.next;
    }
}
