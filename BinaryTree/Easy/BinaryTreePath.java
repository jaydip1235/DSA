//https://leetcode.com/problems/binary-tree-paths/

import java.util.*;
import java.io.*;


public class BinaryTreePath {

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



    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> paths = new ArrayList<>();
        if(root==null)return paths;
        func(root,"",paths);   
        return paths;    
       }
       
       public static void func(TreeNode node, String path,List<String> paths){
           path+=node.val;
           if(node.right==null && node.left==null){
               paths.add(path);
               return;
           }
           if(node.left!=null){
               func(node.left,path+"->",paths);
           }
             if(node.right!=null){
               func(node.right,path+"->",paths);
           }
       }

}
