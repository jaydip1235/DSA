// https://leetcode.com/problems/invert-binary-tree/
import java.util.*;

public class InvertBinaryTree {
    
    public TreeNode invertTree(TreeNode node) {
        if(node==null)return null;
        
        if(node.left!=null && node.right!=null){
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            node.left = invertTree(node.left);
            node.right = invertTree(node.right);
            return node;
        }
        if(node.left!=null){
            node.right = invertTree(node.left);
            node.left = null;
            return node;
        }
          if(node.right!=null){
            node.left = invertTree(node.right);
             node.right = null;
            return node;  
        }
        return node; 
    }

}
