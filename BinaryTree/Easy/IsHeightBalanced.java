// https://leetcode.com/problems/balanced-binary-tree/
import java.util.*;
import java.io.*;


public class IsHeightBalanced {
        
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


    public static class IBPair{
        int ht;
        boolean isBalanced;
        public IBPair(int ht, boolean isBalanced){
            this.ht = ht;
            this.isBalanced= isBalanced;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        IBPair pp =  isBalancedHelper(root);
        return pp.isBalanced;
    }
    public IBPair isBalancedHelper(TreeNode node){
        if(node==null){
            return new IBPair(-1,true);
        }
        IBPair lpair = isBalancedHelper(node.left);
        IBPair rpair = isBalancedHelper(node.right);
        int maxh = Math.max(lpair.ht,rpair.ht)+1;
        boolean isBal = lpair.isBalanced && rpair.isBalanced && 
            (Math.abs(lpair.ht-rpair.ht)<=1);
        return new IBPair(maxh,isBal);
    }
}
