// https://leetcode.com/problems/average-of-levels-in-binary-tree/
import java.util.*;
import java.io.*;

public class AverageOfLevels {

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



    public List<Double> averageOfLevels(TreeNode node) {
        List <Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            int size = q.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode top = q.remove();
                sum+=top.val;
                if(top.left!=null)q.add(top.left);
                if(top.right!=null)q.add(top.right);
            }
            sum/=size;
            ans.add(sum);
        }
       
        return ans;
    }
}
