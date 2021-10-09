// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
import java.util.*;
public class VerticalOrderTraversal {
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
        
  
    public static class verticalPair {
        TreeNode node = null;
        int hl = 0;
        verticalPair(TreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    // ans = {minHl,maxHL}
    public static void width(TreeNode root, int hl, int[] ans) {
        if (root == null)
            return;

        ans[0] = Math.min(hl, ans[0]);
        ans[1] = Math.max(hl, ans[1]);

        width(root.left, hl - 1, ans);
        width(root.right, hl + 1, ans);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<verticalPair> que = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val; // this - other for default behaviour
        });
        PriorityQueue<verticalPair> childQue = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val;
        });

        int[] minMax = new int[2];
        width(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length; i++)
            ans.add(new ArrayList<>());

        que.add(new verticalPair(root, -minMax[0]));

        while (que.size() != 0) {
            verticalPair rp = que.remove();

            ans.get(rp.hl).add(rp.node.val);

            if (rp.node.left != null)
                childQue.add(new verticalPair(rp.node.left, rp.hl - 1));

            if (rp.node.right != null)
                childQue.add(new verticalPair(rp.node.right, rp.hl + 1));

            if (que.size() == 0) {
                PriorityQueue<verticalPair> temp = que;
                que = childQue;
                childQue = temp;
            }
        }

        return ans;

    }

}
