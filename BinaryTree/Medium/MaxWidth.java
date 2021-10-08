// https://leetcode.com/problems/maximum-width-of-binary-tree/
import java.util.*;
public class MaxWidth {
    static class Pair{
        TreeNode node;
        int level;
        Pair(){
            
        }
        Pair(TreeNode node,int level){
            this.node = node;
            this.level=level;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if(root==null)return ans;
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair(root,0));
        while(q.size()>0){
            int count = q.size();
            int max=Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            while(count-->0){
                Pair r = q.remove();
                int lev = r.level;
                min = Math.min(lev,min);
                max = Math.max(lev,max);
                if(r.node.left!=null)q.add(new Pair(r.node.left,2*lev+1));
                if(r.node.right!=null)q.add(new Pair(r.node.right,2*lev+2));
            }
            ans = Math.max(ans,max-min+1);
            }
         return ans;
        }
       
}
