// https://leetcode.com/problems/leaf-similar-trees/
import java.util.*;
public class LeafSimilar {    
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        getLeaves(root1, l);
        getLeaves(root2, r);
        return l.equals(r);
    }
    public void getLeaves(TreeNode node,  ArrayList<Integer>arr){
        if(node==null)return;
        if(node.left==null && node.right==null){
            arr.add(node.val);
            return;
        }
        getLeaves(node.left,arr);
        getLeaves(node.right,arr);
    }
}
