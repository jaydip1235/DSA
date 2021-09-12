// https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
import java.util.*;
public class BusyStudent {
    public int busyStudent(int[] s, int[] e, int q) {
        int arr[] = new int[1002];
        
        for(int i=0;i<s.length;i++){
            arr[s[i]]++;
        }
         for(int i=0;i<e.length;i++){
           arr[e[i]+1]--;
        }
        for(int i=1;i<=1000;i++){
            arr[i]+=arr[i-1];
        }
        return arr[q];
    }
}
