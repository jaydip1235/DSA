// https://leetcode.com/problems/merge-two-binary-trees/
import java.util.*;
import java.io.*;

public class Merge {
    

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode mergeTrees(TreeNode n1, TreeNode n2) {
        if(n2==null)return n1;
        if(n1==null) return n2;
        n1.val+=n2.val;
        n1.left = mergeTrees(n1.left, n2.left);
        n1.right = mergeTrees(n1.right, n2.right);
        return n1;
    }
}
