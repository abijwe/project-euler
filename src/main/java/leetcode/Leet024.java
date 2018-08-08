package leetcode;

import util.ListNode;

public class Leet024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
            swap(first, second, prev);
            head = prev == null ? second : head;
            prev = first;
            first = first.next;
            second = first != null ? first.next : null;
        }
        return head;
    }

    private void swap(ListNode first, ListNode second, ListNode prev) {
        if (prev != null) {
            prev.next = second;
        }
        first.next = second.next;
        second.next = first;
    }
}
