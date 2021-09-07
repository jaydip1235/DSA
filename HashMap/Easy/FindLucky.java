// https://leetcode.com/problems/find-lucky-integer-in-an-array/
import java.util.*;
public class FindLucky {
    public int findLucky(int[] arr) {
        HashMap <Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],1);
            }
            else{
                hm.put(arr[i],hm.get(arr[i])+1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int in : hm.keySet()){
            if(hm.get(in)==in){
                max = Math.max(max,in);
            }
        }
        if(max==Integer.MIN_VALUE)return -1;
        return max;
    }
}
