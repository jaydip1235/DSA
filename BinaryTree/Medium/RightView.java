// https://leetcode.com/problems/binary-tree-right-side-view/
import java.util.*;
public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
         if(root==null)return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            int count = q.size();
            while(count-->0){
                TreeNode r = q.remove();
                if(count==0)ans.add(r.val);
                if(r.left!=null)q.add(r.left);
                if(r.right!=null)q.add(r.right);
            }
        }
        return ans;
    } 
}
