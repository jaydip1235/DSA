// https://leetcode.com/problems/last-stone-weight/
import java.util.*;
public class LastStoneWeight {
    public int lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
            
        while(pq.size()>1){
            int f = pq.remove();
            int s = pq.remove();
            if(f-s!=0){
                pq.add(Math.abs(f-s));
            }
        }
        if(pq.size()==0)return 0;
        return pq.peek();
    }
}
