// https://leetcode.com/problems/convert-bst-to-greater-tree/
import java.util.*;
public class ConvertToGT {

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

    int sum = 0;
    public TreeNode convertBST(TreeNode node) {
        if(node==null)return null;
        convertBSTHelper(node);
        return node;
    }
    public void convertBSTHelper(TreeNode node){
        if(node==null)return;
        convertBSTHelper(node.right);
        int data = node.val;
        sum += data;
        node.val = sum;
        convertBSTHelper(node.left);
    }
    
}
