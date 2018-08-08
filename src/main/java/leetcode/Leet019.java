package leetcode;

import util.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * 
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 
 * @author abijwe
 */
public class Leet019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        ListNode nth = null;
        ListNode prevNth = null;

        int count = 1;
        boolean adv = false;
        while (end != null) {

            if (adv == true) {
                prevNth = nth;
                nth = nth.next;
            }

            if (count == n) {
                nth = head;
                adv = true;
            }
            end = end.next;
            count++;
        }
        if (prevNth == null) {
            return head.next;
        } else {
            prevNth.next = nth.next;
            return head;
        }
    }

}
