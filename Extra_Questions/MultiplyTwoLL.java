// 1. You are given two single linkedlist of digits. 
// 2. The most significant digit comes first and each of their nodes contain a single digit. Multiply the two numbers and return it as a linked list.
// 3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
import java.util.*;
public class MultiplyTwoLL {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode node) {



        if (node == null || node.next == null)
            return node;

        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode forw = curr.next; // backup.

            curr.next = prev; // connection

            prev = curr; // move forw.
            curr = forw;
        }

        return prev;
    }

    public static void addTwoLinkedList(ListNode l1, ListNode l2) {
        ListNode prev = l1;
        int carry = 0;
        while (l2 != null || carry != 0) {
            int sum = carry + (prev.next != null ? prev.next.val : 0) + (l2 != null ? l2.val : 0);

            carry = sum / 10;
            sum = sum % 10;

            if (prev.next != null)
                prev.next.val = sum;
            else
                prev.next = new ListNode(sum);

            if (l2 != null)
                l2 = l2.next;
            prev = prev.next;
        }
    }

    public static ListNode multiplyLinkedListWithDigit(ListNode l1, int digit) {
        ListNode head = new ListNode(-1); // dummy.
        ListNode curr = head;

        int carry = 0;
        while (l1 != null || carry != 0) {
            int sum = carry + (l1 != null ? (l1.val * digit) : 0);

            carry = sum / 10;
            sum = sum % 10;

            curr.next = new ListNode(sum);

            if (l1 != null)
                l1 = l1.next;
            curr = curr.next;
        }

        return head.next;
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode ans = new ListNode(-1); // dummy.
        ListNode ans_itr = ans;
        ListNode l2_itr = l2;

        while (l2_itr != null) {
            ListNode head = multiplyLinkedListWithDigit(l1, l2_itr.val);
            l2_itr = l2_itr.next;
            addTwoLinkedList(ans_itr,head);
            ans_itr = ans_itr.next;
        }
        
        ans = ans.next;
        return reverseList(ans);
    }

}
