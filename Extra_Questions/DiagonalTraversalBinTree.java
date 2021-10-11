// Given a Binary Tree, print Diagonal Order of it. 
import java.util.*;
public class DiagonalTraversalBinTree{
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            int size = que.size();
            ArrayList<Integer> smallAns = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = que.removeFirst();

                while (node != null) {
                    smallAns.add(node.val);
                    if (node.left != null) {// add in que for next diagonal process.
                        que.addLast(node.left);
                    }
                    node = node.right;// move forward in respective diagonal.
                }
            }

            ans.add(smallAns);
        }
        return ans;
    }
}