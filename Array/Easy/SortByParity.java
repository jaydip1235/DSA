// https://leetcode.com/problems/sort-array-by-parity/
import java.util.* ;
public class SortByParity {
    public int[] sortArrayByParity(int[] arr) {
        int i=0,j=0;
        while(i<arr.length){
            if(arr[i]%2==0){
                swap(arr,i,j);
                j++;
                i++;
            }
            else{
                i++;
            }
        }
        return arr;
    }
    public void swap(int []arr, int i, int j){
        int ith = arr[i];
        int jth = arr[j];
        arr[i]=jth;
        arr[j]=ith;
    }
}
