// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
import java.util.*;
public class LCAOfDeepest {
    

    static class Pair {
        TreeNode node;
        int level;

        Pair() {
        }

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null)
            return null;
        Pair p = func(root);
        return p.node;
    }

    public static Pair func(TreeNode root) {
        if (root == null) {
            return new Pair(root, 0);
        }
        Pair left = func(root.left);
        Pair right = func(root.right);
        if (left.level == right.level) {
            return new Pair(root, left.level + 1);
        } else if (left.level > right.level) {
            return new Pair(left.node, left.level + 1);
        } else
            return new Pair(right.node, right.level + 1);
    }

}
