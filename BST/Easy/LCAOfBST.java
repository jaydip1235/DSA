// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
import java.util.*;
public class LCAOfBST {

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
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(node==null)return null;
        if(p.val<node.val && q.val<node.val){
            return  lowestCommonAncestor(node.left,p,q);
        }
        if(p.val>node.val && q.val>node.data){
            return  lowestCommonAncestor(node.right,p,q);
        }
        return node;
    }
}
