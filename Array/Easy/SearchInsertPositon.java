// https://leetcode.com/problems/search-insert-position/
import java.util.*;

public class SearchInsertPosition{
    public int searchInsert(int[] arr, int target) {
        
        int hi=arr.length-1;
        int lo=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return lo;
        
    }
}