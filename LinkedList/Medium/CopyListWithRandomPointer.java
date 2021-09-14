// https://leetcode.com/problems/copy-list-with-random-pointer/
import java.util.*;
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node dh = new Node(-1);
        Node dt = dh;
        HashMap<Node,Node> hm = new HashMap<>();
        Node temp = head;
        
        while(temp!=null){
            Node nn = new Node(temp.val);
            dt.next = nn;
            dt=nn;
            hm.put(temp,nn);
            temp=temp.next;
        }
        Node p1 = head;
        Node p2 = dh.next;
        while(p1!=null){
            if(p1.random==null)p2.random = null;
            else p2.random = hm.get(p1.random);
            p1=p1.next;
            p2=p2.next;
        }
        return dh.next;
    }
}
