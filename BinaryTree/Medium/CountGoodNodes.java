// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
import java.util.*;
public class CountGoodNodes {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode root, int max) {
        if(root == null) return 0;
        
        max = Math.max(max, root.val);
        if(root.val >= max)
            return 1 + dfs(root.left, max) + dfs(root.right, max);
        else
            return dfs(root.left, max) + dfs(root.right, max);
    }
}
