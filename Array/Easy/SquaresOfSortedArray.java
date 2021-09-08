// https://leetcode.com/problems/squares-of-a-sorted-array/
import java.util.*;
public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] arr) {
        int i=0;
        int ans[] = new int[arr.length];
        int j = arr.length-1;
        int pos=0;
        while(i<=j){
            if((arr[i]*arr[i]) < (arr[j]*arr[j]))
            {
                ans[pos++] = (arr[j]*arr[j]);
                j--;
            }
            else if((arr[i]*arr[i]) > (arr[j]*arr[j])){
                ans[pos++] = (arr[i]*arr[i]);
                i++;
            }
            else{
                //System.out.println("sd");
                 ans[pos++] = (arr[i]*arr[i]);
                if(pos<arr.length)
                 ans[pos++] = (arr[j]*arr[j]);
                i++;
                j--;
            }
        }
        i=0;
        j=arr.length-1;
        while(i<=j){
            int temp = ans[i];
            ans[i]=ans[j];
            ans[j]=temp;
            i++;j--;
        }
      return ans; 
    }
}
