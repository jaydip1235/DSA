// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
import java.util.*;
public class MaxDepth {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node node) {
        if(node==null)return 0;
        int ht = 0;
        for(Node child : node.children){
            ht = Math.max(ht,maxDepth(child));
        }
        return ht+1;
    }
}
