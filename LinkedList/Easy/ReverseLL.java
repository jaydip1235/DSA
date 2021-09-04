// https://leetcode.com/problems/reverse-linked-list/
import java.util.*;

public class ReverseLL {
    static ListNode leftptr;
    static int size;
  public ListNode reverseList(ListNode head) {
      if(head==null)return null;
      leftptr = head;
      ListNode temp = head;
      size = 0;
      while(temp!=null){
          temp = temp.next;
          size++;
      }
      //System.out.println(size);
      revHelper(head,0);
      return head;
  }
  public void revHelper(ListNode node, int idx){
      if(node==null)return;
      revHelper(node.next, idx+1);
      if(idx>=size/2){
          ListNode right = node;
          int temp = right.val;
          right.val = leftptr.val;
          leftptr.val = temp;
          leftptr = leftptr.next;
      }
  }
}
