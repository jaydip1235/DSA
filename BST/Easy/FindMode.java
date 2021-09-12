// https://leetcode.com/problems/find-mode-in-binary-search-tree/
import java.util.*;
public class FindMode {
    Integer prev=null;
    int count=1;
    int max=0;
    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        traverse(root,ans);
        
        int arr[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
    
    public void traverse(TreeNode node, List<Integer>ans){
        if(node==null)return;
        traverse(node.left,ans);
        
        
        if(prev!=null){
            if(prev==node.val){
                count++;
            }else{
                count=1;
            }
        }
        
        if(count>max){
            max=count;
            ans.clear();
            ans.add(node.val);
        }else if(count==max){
            ans.add(node.val);
        }
        
        prev=node.val;
        traverse(node.right,ans);
    }  
}
