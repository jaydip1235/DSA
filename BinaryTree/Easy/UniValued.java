// https://leetcode.com/problems/univalued-binary-tree/
import java.util.*;
import java.io.*;

public class UniValued {


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

    public boolean isUnivalTree(TreeNode root) {
        return univalHelper(root, root.val);
    }
    public boolean univalHelper(TreeNode node, int data){
        if(node==null)return true;
        if(node.val!=data)return false;
        return univalHelper(node.left, data) && univalHelper(node.right, data);
    }
    
}
