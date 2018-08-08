package leetcode;

import util.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/description/
 * 
 * @author abijwe
 */
public class Leet021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode retNode = new ListNode(0);
        ListNode currNode = retNode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                currNode.next = l2;
                l2 = l2.next;
                break;
            } else if (l2 == null) {
                currNode.next = l1;
                l1 = l1.next;
                break;
            } else {
                if (l1.val < l2.val) {
                    currNode.next = l1;
                    l1 = l1.next;
                } else {
                    currNode.next = l2;
                    l2 = l2.next;
                }
            }
            currNode = currNode.next;
        }
        return retNode.next;
    }

}
