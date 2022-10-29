https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/0
class PaintersPartitionProblemII{
    static long minTime(int[] arr,int n,int k){
        //code here
        long max = arr[0];
        long sum = arr[0];
        long mid;
        
        for(int i=1; i<n ; i++){
            if(max < arr[i])
            max = arr[i];
            sum+=arr[i];
        }
        
        if(k > n)
        return max;
        
        while(max < sum){
            mid = max + (sum-max)/2;
            if(isPossible(arr,n,k,mid))
            sum = mid;
            else
            max = mid+1;
        }
        return sum;
    }
    
    private static boolean isPossible(int[] arr,int n,int k, long maxTime){
        long timeTaken=0;
        int painters=1;
        for(int i=0; i<n; i++){
            timeTaken +=arr[i];
            if(timeTaken > maxTime){
                painters++;
                if(painters > k)
                    return false;
                timeTaken=arr[i];
            }
        }
        return true;
    }
}
