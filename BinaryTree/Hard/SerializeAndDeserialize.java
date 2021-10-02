// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
import java.util.*;
public class SerializeAndDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "*";
        }
        
        String ls = serialize(root.left);
        String rs = serialize(root.right);
        
        return root.val + " " + ls + " " + rs;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        k = 0;
        String[]arr = data.split(" ");
        return helper(arr);
    }
    
    int k;
    public TreeNode helper(String[]arr) {
        if(arr[k].equals("*") == true) {
            k++;
            return null;
        }
        else {
            int data = Integer.parseInt(arr[k]);
            k++;
            
            TreeNode node = new TreeNode(data);
            
            node.left = helper(arr);
            node.right = helper(arr);
            
            return node;
        }
        
    }
}
