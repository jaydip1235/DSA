// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
import java.util.*;
public class SortedToBST {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return Helper(nums,0,nums.length-1);
    }
    public TreeNode Helper(int[] nums, int l, int h){
        if(l>h)return null;
        int mid = (l+h)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = Helper(nums,l,mid-1);
        node.right = Helper(nums,mid+1,h);
        return node;
    }
}
