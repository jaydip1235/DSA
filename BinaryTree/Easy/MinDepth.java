// https://leetcode.com/problems/minimum-depth-of-binary-tree/
import java.util.*;
import java.io.*;

public class MinDepth {

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
    
    

    public int minDepth(TreeNode node) {
        if(node==null)return 0;
        int lht = minDepth(node.left);
        int rht = minDepth(node.right);
        if(lht>0 && rht>0)
        return Math.min(lht,rht)+1;
        else if(lht>0){
            return lht+1;
        }
        else return rht+1;
    }
}
