// https://leetcode.com/problems/relative-sort-array/
import java.util.*;
public class RelativeSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
     
        List<Integer> ans = new ArrayList<>();
         Map<Integer,Integer> hm = new TreeMap<>();
        for(int i=0;i<arr1.length;i++){
            if(!hm.containsKey(arr1[i]))hm.put(arr1[i],1);
            else hm.put(arr1[i],hm.get(arr1[i])+1);
        }
        for(int i=0;i<arr2.length;i++){
            for(int j=1;j<=hm.get(arr2[i]);j++){
                 ans.add(arr2[i]);
             }
            hm.remove(arr2[i]);
        }
        for(int ii : hm.keySet()){
            for(int i=1;i<=hm.get(ii);i++)ans.add(ii);
        }
        int[] arr = new int[ans.size()];
          for (int i = 0; i < ans.size(); i++)
            arr[i] = ans.get(i);
  
        return arr;
        
    }
}
