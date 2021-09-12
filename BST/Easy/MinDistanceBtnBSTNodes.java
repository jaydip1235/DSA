// https://leetcode.com/problems/minimum-distance-between-bst-nodes/
import java.util.*;
public class MinDistanceBtnBSTNodes {
    ArrayList<Integer> al = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        if(root==null)return 0;
        getInorder(root);
        int mini = Integer.MAX_VALUE;
        for(int i=1;i<al.size();i++){
            if(al.get(i)-al.get(i-1)<mini) mini = al.get(i)-al.get(i-1);
        }
        return mini;
    }
    public void getInorder(TreeNode node){
        if(node==null)return;
        getInorder(node.left);
        al.add(node.val);
        getInorder(node.right);
    }
}
