// https://practice.geeksforgeeks.org/problems/equivalent-sub-arrays3731/1#
import java.util.*;
public class EquivalentSubarray {
    static int countDistinctSubarray(int arr[], int n) 
    { 
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int k=set.size();
        int i=-1;
        int j=-1;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(i<arr.length-1){
            //acquire
            while(i<arr.length-1 && map.size()<k){
                i++;
                int num = arr[i];
                int freq = map.getOrDefault(num,0)+1;
                map.put(num,freq);
                
                if(map.size()==k){
                    count+=(n-i);
                    break;
                }
            }
            
            //release
            while(j<i && map.size()==k){
                j++;
                int num = arr[j];
                if(map.get(num)>1){
                    count+=(n-i);
                    map.put(num,map.getOrDefault(num,0)-1);
                   
                }
                else{
                    map.remove(num);
                    break;
                }
                
            }
        }
        return count;

    }
}
