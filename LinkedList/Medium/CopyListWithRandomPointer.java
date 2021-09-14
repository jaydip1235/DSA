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



        // Optimized implementation
        public Node copyRandomList(Node head) {
            if(head==null)return null;
            Node curr = head;
    
            while (curr != null) {
                Node n = curr.next;
    
                Node nn = new Node(curr.val);
    
                curr.next = nn;
                nn.next = n;
    
                curr = n;
            }
    
    
            //2. set random pointers
            Node p1 = head;
    
            while (p1 != null) {
                Node p2 = p1.next;
    
                if (p1.random == null) {
                    p2.random = null;
                } else {
                    p2.random = p1.random.next;
                }
    
                p1 = p1.next.next;
    
            }
    
            //3. segregate old and new list
            Node cllh = head.next; //copied linked list head
    
            Node h1 = head;
            Node h2 = cllh;
    
            while (h1 != null) {
                Node n1 = h2.next;
    
                Node n2 = null;
    
                if (n1 != null) {
                    n2 = n1.next;
                }
    
                h1.next = n1;
                h2.next = n2;
    
                h1 = n1;
                h2 = n2;
            }
    
    
            return cllh;
    }
       
}
