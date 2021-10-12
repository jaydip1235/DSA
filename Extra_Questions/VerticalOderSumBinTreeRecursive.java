// Given a Binary Tree, print Vertical Order Sum of it. 
import java.util.*;
public class VerticalOderSumBinTreeRecursive {
        public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    private static void width(TreeNode root, int hl, int []minmax){
        if(root==null)return;
        
        minmax[0]=Math.min(minmax[0],hl);
        minmax[1]=Math.max(minmax[1],hl);
        
        width(root.left,hl-1,minmax);
        width(root.right,hl+1,minmax);
    }
    
    private static void dfs(TreeNode root, int hl, ArrayList<Integer>arr){
        if(root==null)return;
        arr.set(hl,arr.get(hl)+root.val);
        dfs(root.left,hl-1,arr);
        dfs(root.right,hl+1,arr);
    }

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root==null)return arr;
        int minmax[] = new int[2];
        width(root,0,minmax);
        int len = minmax[1]-minmax[0]+1;
        for(int i=0;i<len;i++)arr.add(0);
        dfs(root,Math.abs(minmax[0]),arr);
        return arr;
    }

}
