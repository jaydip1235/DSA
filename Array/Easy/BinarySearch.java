// https://leetcode.com/problems/binary-search/
import java.util.*;
public class BinarySearch {
    public int search(int[] arr , int t) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            if(arr[mid]==t)return mid;
            if(arr[mid]<t)lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }
}
