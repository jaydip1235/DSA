// 1. You are give two single linkedlist of digits. 
// 2. The most significant digit comes first and each of their nodes contain a single digit. Subtract the two numbers and return it as a linked list.
// 3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// 4. any list can be larger in term of number.

import java.util.*;
public class SubtractTwoLL {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int size(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    //1 -> l1 > l2
    //-1 -> l1 < l2
    //0 -> l1 == l2
    public static int compare(ListNode l1, ListNode l2) {
        int c1 = size(l1);
        int c2 = size(l2);

        if (c1 < c2) {
            return -1;
        } else if (c1 > c2) {
            return 1;
        } else {
            ListNode t1 = l1;
            ListNode t2 = l2;

            while (t1 != null && t2 != null) {
                if (t1.val > t2.val) {
                    return 1;
                } else if (t1.val < t2.val) {
                    return -1;
                } else {
                    t1 = t1.next;
                    t2 = t2.next;
                }
            }
        }

        return 0;
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {

        ListNode t1 = null; //larger number ptr
        ListNode t2 = null; //smaller number ptr

        int cr = compare(l1, l2);

        if (cr == 0) {
            //both are equals
            return new ListNode(0);
        } else if (cr == 1) {
            //number represented by l1 is larger
            t1 = reverse(l1);
            t2 = reverse(l2);
        } else {
            //number represented by l2 is larger
            t1 = reverse(l2);
            t2 = reverse(l1);
        }

        //subtract t1-t2
        int borrow = 0;
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;

        while (t1 != null) {
            int sub = (t1.val + borrow);

            if (t2 != null) {
                sub -= t2.val;
                t2 = t2.next;
            }

            if (sub < 0) {
                sub += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }

            ListNode nn = new ListNode(sub);
            dt.next = nn;
            dt = dt.next;

            t1 = t1.next;
        }

        ListNode ans = reverse(dh.next);

        //shifiting the head to avoid leading zero
        while (ans != null && ans.val == 0) {
            ans = ans.next;
        }

        return ans;
    }
}
