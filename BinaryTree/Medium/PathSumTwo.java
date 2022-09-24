// https://leetcode.com/problems/path-sum-ii/
import java.util.*;
public class PathSumTwo{
    class TreeNode {
    
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
      
        }
       TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
    }
     public void helper(TreeNode root, int targetSum, List<Integer>smallAns,List<List<Integer>> res){
        if(root==null)return;
        if(root.left==null && root.right==null){
            if(targetSum-root.val==0){
                List<Integer>base = new ArrayList<>(smallAns);
                base.add(root.val);
                res.add(base);
            }
            return;
        }
        smallAns.add(root.val);
        helper(root.left,targetSum-root.val,smallAns,res);
        helper(root.right,targetSum-root.val,smallAns,res);
        smallAns.remove(smallAns.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>smallAns = new ArrayList<>();
        helper(root,targetSum,smallAns,res);
        return res;
    }
}