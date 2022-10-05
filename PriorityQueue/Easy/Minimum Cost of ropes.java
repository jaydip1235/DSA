// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

class Solution
{
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long>pq = new PriorityQueue<>();
        long cost =0;
        
        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }
        
        while(pq.size()>=2){
            long first  = pq.peek();
            pq.poll();
            long second = pq.peek();
            pq.poll();
            cost = cost+first+second;
            pq.add(first+second);
        }
        return cost;
    }
}