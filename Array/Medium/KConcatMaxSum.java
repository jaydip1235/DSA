// https://leetcode.com/problems/k-concatenation-maximum-sum/
public class KConcatMaxSum {
        public int kConcatenationMaxSum(int[] arr, int k) {
        long m = 1000000007;
        if(k==1) return (int)(kadanes(arr)%m);
        long sum = 0;
        for(int val : arr){
            sum+=val;
        }
        if(sum<0) return (int)(kadanesFirstTwo(arr)%m);
        else{
           return (int)((kadanesFirstTwo(arr) + ((k-2)*sum))%m);
        }
    }
    private long kadanes(int arr[]){
        long maxSum = 0;
        long currSum = 0;
        for(int i =0;i<arr.length;i++){
            if(currSum<0) currSum = arr[i];
            else currSum=(currSum+arr[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
    private long kadanesFirstTwo(int arr[]){
        long maxSum = 0;
        long currSum = 0;
        for(int i =0;i<2*arr.length;i++){
            if(currSum<0) currSum= arr[i%arr.length];
            else currSum=(currSum+arr[i%arr.length]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}

