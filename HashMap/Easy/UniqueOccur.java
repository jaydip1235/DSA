// https://leetcode.com/problems/unique-number-of-occurrences/
import java.util.*;
public class UniqueOccur{
    public boolean uniqueOccurrences(int[] arr) {
        int freq[] = new int[2001];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]+1000]++;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<freq.length;i++){
            if(freq[i]==0)continue;
            if(hm.containsKey(freq[i]))return false;
            hm.put(freq[i],1);
        }     
        return true;
        
    }
}