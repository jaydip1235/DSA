//https://leetcode.com/problems/symmetric-tree/ 
import java.util.*;
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode node1, TreeNode node2){
        if(node1==null || node2==null)return node1==node2;
        if(node1.val != node2.val)return false;
        return (isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left));
    }

}
