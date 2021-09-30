// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
import java.util.*;
public class TreeFromInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        TreeNode root = helper(postorder,inorder,0,n-1,0,n-1);
        
        return root;
    }
    
    public TreeNode helper(int[]post,int[]in,int ps,int pe,int is,int ie) {
        
        if(ps > pe) {
            return null;
        }
        
        TreeNode node = new TreeNode(post[pe]);
        
        int k = -1;
        
        for(int i = is; i <= ie;i++) {
            if(in[i] == node.val) {
                k = i;
                break;
            }
        }
        
        int cls = k - is;
        
        node.left = helper(post,in,ps,ps + cls - 1,is, k - 1);
        node.right = helper(post,in,ps + cls,pe - 1,k + 1,ie);
        
        return node;
    }
}
