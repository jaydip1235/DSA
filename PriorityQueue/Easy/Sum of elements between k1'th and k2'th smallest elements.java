//https://practice.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1

class Solution { 
    public static long sumBetweenTwoKth(long arr[], long N, long K1, long K2)
    {
        long first = kthSmallest(arr,K1);
        long second = kthSmallest(arr,K2);
        long sum =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>first && arr[i]<second){
                sum+=arr[i];
            }
        }
        return sum;
    }
    
    private static long kthSmallest(long[] arr, long k){
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);
            
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
    
}