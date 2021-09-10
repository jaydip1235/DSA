// https://leetcode.com/problems/count-largest-group/
import java.util.*;
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        int res = 0,ans =0;
        int arr[] = new int[37];
        for(int i=1;i<=n;i++){
            int dsum = func(i);
            arr[dsum]++;
            if(arr[dsum]>res)res = arr[dsum];
        }        
        for(int i=1;i<37;i++){
            if(arr[i]==res)ans++;
        }
        return ans;
    }
    int func(int n){
        int sum = 0;
        while(n!=0){
            int rem = n%10;
            sum+=rem;
            n/=10;
        }
        return sum;
    }
}
