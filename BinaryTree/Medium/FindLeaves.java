// https://www.lintcode.com/problem/650/

import java.util.*;
import java.io.*;



public class FindLeaves {
     public class TreeNode {
             public int val;
             public TreeNode left, right;
             public TreeNode(int val) {
                 this.val = val;
                 this.left = this.right = null;
             }
         }
 
    public List<List<Integer>> findLeaves(TreeNode node) {
     List<List<Integer>> ans = new ArrayList<>();
     if(node==null)return ans;
     level(node, ans);
     return ans;
    }
    public static int level(TreeNode node,  List<List<Integer>> ans){
        if(node==null)return -1;
        int level = Math.max(level(node.left,ans), level(node.right,ans))+1;
        if(ans.size()<=level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        return level;
    }
}