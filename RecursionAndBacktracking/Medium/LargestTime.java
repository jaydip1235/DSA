// https://leetcode.com/problems/largest-time-for-given-digits/
import java.util.*;
public class LargestTime {
    ArrayList<String> al = new ArrayList<>();
    
    public String largestTimeFromDigits(int[] arr) {
    HashMap<Integer, Integer> fmap = new HashMap<>();
    for(int in: arr){
      if(fmap.containsKey(in)){
        fmap.put(in, fmap.get(in) + 1);
      } else {
        fmap.put(in, 1);
      }
    }
      generate(1, arr.length, fmap, ""); 
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
      for(String s: al){
          if(Integer.parseInt(s.substring(0,2))<=23 && Integer.parseInt(s.substring(2,4))<=59){
              pq.add(s);
      }  
      }  
        if(pq.size()==0)return "";
         String ans = pq.remove();
         return ans.substring(0,2)+":"+ans.substring(2,4);
    }
    
    public void generate(int cs, int ts, HashMap<Integer, Integer> fmap, String asf) {
    if(cs > ts){
      al.add(asf);
      return;
    }

    for (int inn : fmap.keySet()) {
      if (fmap.get(inn) > 0) {
        fmap.put(inn, fmap.get(inn) - 1);
        generate(cs + 1, ts, fmap, asf + (char)(inn+'0'));
        fmap.put(inn, fmap.get(inn) + 1);
      }
    }
  }
}
