// https://leetcode.com/problems/path-sum-iii/
import java.util.*;
public class PathSum3 {
    
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0; 
        HashMap<Integer,Integer> hm =  new HashMap<>();
        hm.put(0,1);
        return helper(root,0,targetSum, hm);
       }
       
       public int helper(TreeNode node, int runningSum, int target, HashMap<Integer,Integer> hm){
           if(node==null) return 0;
           runningSum+=node.val;
           int count = hm.getOrDefault(runningSum-target,0);
           hm.put(runningSum, hm.getOrDefault(runningSum,0)+1);
           count += helper(node.left,runningSum,target,hm)+helper(node.right,runningSum,target,hm);
           hm.put(runningSum, hm.get(runningSum)-1);
           return count;
       }
}
