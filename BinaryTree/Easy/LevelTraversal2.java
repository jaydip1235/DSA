// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
import java.util.*;
import java.io.*;


public class LevelTraversal2 {
    
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

    public List<List<Integer>> levelOrderBottom(TreeNode node) {
        List<List<Integer>> ans= new ArrayList<>();
          if(node==null) return ans;
          Queue<TreeNode> q = new ArrayDeque<>();
          q.add(node);
          while(q.size()>0){
              int size = q.size();
              List<Integer> temp = new ArrayList<>();
              for(int i=0;i<size;i++){
                  TreeNode top = q.remove();
                  temp.add(top.val);
                  if(top.left!=null)q.add(top.left);
                  if(top.right!=null)q.add(top.right);
              }
              ans.add(0,temp);
          }
         
          return ans;
      }
}
