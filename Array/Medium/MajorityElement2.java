// https://leetcode.com/problems/majority-element-ii/submissions/
import java.util.*;
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        int num1 = Integer.MIN_VALUE, num2=Integer.MIN_VALUE , c1=0,c2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num1)c1++;
            else if(arr[i]==num2)c2++;
            else if(c1==0){
                c1=1;
                num1 = arr[i];
            }
             else if(c2==0){
                c2=1;
                num2 = arr[i];
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;c2=0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num1)c1++;
             if(arr[i]==num2)c2++;
        }
   
        if(c1>n/3){
            ans.add(num1);
        }
        if(c2>n/3){
            ans.add(num2);
        }
        return ans;
    }
}
