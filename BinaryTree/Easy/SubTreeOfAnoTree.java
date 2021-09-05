// https://leetcode.com/problems/subtree-of-another-tree/
import java.util.*;
public class SubTreeOfAnoTree {
    public boolean isSubtree(TreeNode node, TreeNode sub) {
        if(node==null)return false;
        boolean lsame = isSameTree(node.left,sub);
        boolean rsame = isSameTree(node.right,sub);
        boolean osame =isSameTree(node,sub);
        return (osame || lsame || rsame || isSubtree(node.left,sub) ||  isSubtree(node.right,sub));
    }
    
      public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null)return p==q;
        if(p.val!=q.val)return false;
        return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}
