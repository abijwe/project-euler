package leetcode;

import util.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Link - https://leetcode.com/problems/add-two-numbers/description/
 * 
 * @author abijwe
 */
public class Leet002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retNode = null;
        int currentCarry = 0;
        ListNode currNode = null;
        int l1Val, l2Val;
        while (l1 != null || l2 != null) {
            if (currentCarry == 0 && l1 == null) {
                currNode.next = l2;
                break;
            }

            if (currentCarry == 0 && l2 == null) {
                currNode.next = l1;
                break;
            }

            l1Val = l1 != null ? l1.val : 0;
            l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + currentCarry;
            if (sum > 9) {
                currentCarry = 1;
                sum = sum%10;
            } else {
                currentCarry = 0;
            }
            l1 = l1 != null ? l1.next: l1;
            l2 = l2 != null ? l2.next : l2;
            if (currNode != null) {
                currNode.next = new ListNode(sum);
                currNode = currNode.next;
            } else {
                currNode = new ListNode(sum);
            }
            retNode = retNode == null ? currNode : retNode;
        }
        if (currentCarry > 0) {
            currNode.next = new ListNode(currentCarry);
        }
        return retNode;
    }
}
