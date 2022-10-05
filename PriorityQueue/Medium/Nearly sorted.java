//https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1

class Solution
{
   
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<arr.length; i++){
            pq.offer(arr[i]);
            if(pq.size()>k){
                ans.add(pq.poll());
            }
        }
        
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        
        return ans;
    }
}
