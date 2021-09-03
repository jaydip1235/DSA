// https://leetcode.com/problems/cousins-in-binary-tree/

import java.util.*;
import java.io.*;


public class  Cousins{

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
    public boolean isCousins(TreeNode node, int x, int y) {
        

        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            int size = q.size();
            boolean xExist = false;
            boolean yExist = false;
            for(int i=0;i<size;i++){
                TreeNode top = q.remove();
                if(top.val==x)xExist = true;
                if(top.val==y)yExist = true;
                if(top.left!=null && top.right!=null){
                    if(top.left.val==x && top.right.val==y){
                        return false;
                    }
                    if(top.left.val==y && top.right.val==x){
                        return false;
                    }
                }
                if(top.left!=null){
                    q.add(top.left);
                }
                 if(top.right!=null){
                    q.add(top.right);
                }
            }
            if(xExist && yExist)return true;
        }
        return false;
        
    }
}