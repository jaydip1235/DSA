//https://leetcode.com/problems/maximum-depth-of-binary-tree/
import java.util.*;
import java.io.*;
public class MaxDepth {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int maxDepth(TreeNode node) {
        
        if(node==null)return 0;
        int lh = maxDepth(node.left);
        int rh = maxDepth(node.right);
        int maxi = Math.max(lh,rh);
        return maxi+1;
    }
}
