// https://leetcode.com/problems/smallest-number-in-infinite-set/
import java.util.*;
public class SmallestNoInInfiniteSet{
    class SmallestInfiniteSet {

    PriorityQueue<Integer> pq = null;
    public SmallestInfiniteSet() {
        pq=new PriorityQueue<>(1000);
        for(int i=1;i<=1000;i++){
            pq.add(i);
        }
        
    }
    
    public int popSmallest() {
        int rm = pq.peek();
        pq.remove();
        return rm;
    }
    
    public void addBack(int num) {
        if(!pq.contains(num)){
            pq.add(num);
        }
    }
}
}