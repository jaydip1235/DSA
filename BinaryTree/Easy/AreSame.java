// https://leetcode.com/problems/same-tree/
import java.util.*;
public class AreSame {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
       }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null)return p==q;
        if(p.val!=q.val)return false;
        return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}
