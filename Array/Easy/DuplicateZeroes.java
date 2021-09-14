// https://leetcode.com/problems/duplicate-zeros/
import java.util.*;
public class DuplicateZeroes {
    public void duplicateZeros(int[] arr) {
        
        int zeros = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)zeros++;
        }
        
        int i = arr.length-1;
        int j = arr.length+zeros-1;
        while(i!=j){
            insert(arr,i,j--);
            if(arr[i]==0){
                insert(arr,i,j--);
            }
            i--;
        }
    }
    public void insert(int []arr, int i,int j){
        if(j<arr.length){
            arr[j]=arr[i];
        }
    }
}
