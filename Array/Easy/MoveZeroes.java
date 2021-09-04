// https://leetcode.com/problems/move-zeroes/
import java.util.*;
public class MoveZeroes {
    public void moveZeroes(int[] arr) {
        int i=0, j=0;
        while(i<arr.length){
            if(arr[i]!=0){
                swap(arr,i,j);
                i++;j++;
            }
            else{
                i++;
            }
        }
    }
    public void swap(int[] arr, int i,int j){
        int ith = arr[i];
        int jth = arr[j];
        arr[i]=jth;
        arr[j]=ith;
    }
    
}
