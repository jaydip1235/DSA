//https://leetcode.com/problems/diameter-of-binary-tree/
import java.util.*;
import java.io.*;

public class Diameter {

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

    public int diameterOfBinaryTree(TreeNode node) {

        if(node==null)return 0;
        int ldia = diameterOfBinaryTree(node.left);
        int rdia = diameterOfBinaryTree(node.right);
        int lht = height(node.left);
        int rht = height(node.right);
        int currdia = lht+rht+2;
        return Math.max(currdia, Math.max(ldia,rdia));
    }
    
    public static int height(TreeNode node){
        if(node==null)return -1;
        return Math.max(height(node.left),height(node.right))+1;
    }
}
