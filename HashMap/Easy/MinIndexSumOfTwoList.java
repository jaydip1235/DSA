// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
import java.util.*;
public class MinIndexSumOfTwoList {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        HashMap<String,Integer> hm1 = new HashMap<>();
        HashMap<String,Integer> hm2 = new HashMap<>();
        
        for(int i=0;i<list1.length;i++){
            hm1.put(list1[i],i);
        }
         for(int i=0;i<list2.length;i++){
            hm2.put(list2[i],i);
        }
        for(int i=0;i<list1.length;i++){
            if(hm1.containsKey(list1[i]) && hm2.containsKey(list1[i])){
                hm1.put(list1[i],hm1.get(list1[i])+hm2.get(list1[i]));
            }
            else{
                hm1.remove(list1[i]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        int mini = Integer.MAX_VALUE;
        for(String s : hm1.keySet()){
            if(hm1.get(s)<mini)mini=hm1.get(s);
        }
        for(String s : hm1.keySet()){
            if(hm1.get(s)==mini)ans.add(s);
        }
        String[] anss = new String[ans.size()];
  
        
        for (int i = 0; i < ans.size(); i++)
            anss[i] = ans.get(i);
        return anss;
    }
}
