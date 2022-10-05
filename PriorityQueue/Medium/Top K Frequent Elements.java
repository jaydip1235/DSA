//https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int val: nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->map.get(o1)-map.get(o2));
        
        for(int num:map.keySet()){
           pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int output[] = new int[k];
        int index =0;
        while(!pq.isEmpty()){
            output[index++] = pq.poll();
        }
        
        return output;
    }
}