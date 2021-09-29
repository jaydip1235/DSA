// https://leetcode.com/problems/linked-list-in-binary-tree/
import java.util.*;
public class LLInBinTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null || root==null)return false;
        if (root.val==head.val){
            if(helper(head,root))return true;
        }
        return isSubPath(head,root.left) || isSubPath(head,root.right);
    }
    private boolean helper(ListNode head, TreeNode root){
        if(root==null)return head==null;
        if(head==null)return true;
        if(head.val!=root.val)return false;
        return helper(head.next,root.left) || helper(head.next,root.right);
    }
}
