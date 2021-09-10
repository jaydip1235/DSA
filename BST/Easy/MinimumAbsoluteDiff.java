// https://leetcode.com/problems/minimum-absolute-difference-in-bst/
import java.util.*;
public class MinimumAbsoluteDiff {

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

    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Make(root,arr);
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<arr.size();i++)
            {
                if(arr.get(i)-arr.get(i-1)<ans)ans = arr.get(i)-arr.get(i-1);
            }   
            return ans;
    }
    public void Make(TreeNode node, ArrayList<Integer> arr){
        if(node==null)return;
        Make(node.left,arr);
        arr.add(node.val);
        Make(node.right,arr);
    }
}
