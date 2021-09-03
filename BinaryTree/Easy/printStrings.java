// https://leetcode.com/problems/construct-string-from-binary-tree/
import java.util.*;
import java.io.*;



public class printStrings {

    
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



    String str ="";
    public String tree2str(TreeNode node) {
        tree2strHelper(node);
        return str;
    }
    public void tree2strHelper(TreeNode node){
        if(node==null)return;
   
        if(node.left==null && node.right==null){
            str+=node.val;
            return;
        }
       if(node.right==null){
           str+=node.val+"(";
            tree2strHelper(node.left);
           str+=")";
           return;
       }
         if(node.left==null){
           str+=node.val+"()(";
            tree2strHelper(node.right);
             str+=")";
           return;
       }
    
        str+=node.val+"(";
         tree2strHelper(node.left);
        str+=")";
        
         str+="(";
         tree2strHelper(node.right);
         str+=")";
        
    }
    
}
