// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
import java.util.*;
public class BSTFromPre {
    int idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] preorder, int min, int max) {
        if (idx >= preorder.length || preorder[idx] < min || preorder[idx] > max) {
            return null;
        } else {
            TreeNode node = new TreeNode(preorder[idx]);
            idx++;

            node.left = helper(preorder, min, node.val - 1);
            node.right = helper(preorder, node.val + 1, max);

            return node;
        }
    }
}
