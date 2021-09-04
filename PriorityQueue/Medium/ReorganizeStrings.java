package Medium;
// https://leetcode.com/problems/reorganize-string/

import java.util.*;
public class ReorganizeStrings {
    public String reorganizeString(String s) {
        String ans="";
        Map<Character,Integer> hm = new HashMap<>();
        for(char ss : s.toCharArray()){
            if(!hm.containsKey(ss)){
                 hm.put(ss,1);
            }
            else hm.put(ss,hm.get(ss)+1); 
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        
        pq.addAll(hm.keySet());
        
        while(pq.size()>1){
            char f = pq.remove();
            char se = pq.remove();
            ans+=f;
            ans+=se;
            hm.put(f,hm.get(f)-1);
            hm.put(se,hm.get(se)-1);
            if(hm.get(f)>0){
                pq.add(f);
            }
            if(hm.get(se)>0){
                pq.add(se);
            }
        }
        if(!pq.isEmpty()){
        char last = pq.remove();
        if(hm.get(last)>1)return "";
         ans+=last;
        }
        return ans;
        
    }
}
