//Given a Binary Tree, print Diagonal Order of it anti-clock wise. 
import java.util.*;
public class DiagonalTravBinTreeAnti {
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
                    if (node.right != null) {// add in que for next diagonal process.
                        que.addLast(node.right);
                    }
                    node = node.left;// move forward in respective diagonal.
                }
            }
            ans.add(smallAns);
        }

        return ans;
    }
}
