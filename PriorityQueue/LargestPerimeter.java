// https://leetcode.com/problems/largest-perimeter-triangle/
import java.util.*;

public class LargestPerimeter{
    public int largestPerimeter(int[] arr) {
        
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++)pq.add(arr[i]);
        while(pq.size()>2){
            int lar = pq.remove();
            int slar = pq.remove();
            int tlar = pq.remove();
            if(slar+tlar>lar){
                return slar+lar+tlar;
            }
            else{
                pq.add(slar);
                pq.add(tlar);
            }
        }
        
        return 0;
    }
}
