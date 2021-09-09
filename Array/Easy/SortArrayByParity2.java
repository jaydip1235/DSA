// https://leetcode.com/problems/sort-array-by-parity-ii/
import java.util.*;
public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] arr) {
        int i=0,j=1;
        int n = arr.length;
        while(i<n && j<n){
            while(i<n && arr[i]%2==0)i+=2;
            while(j<n && arr[j]%2==1)j+=2;
            if(i<n && j<n){
                int ith = arr[i];
                int jth = arr[j];
                arr[i]=jth;
                arr[j]=ith;
            }
        }
        return arr;
    } 
}
