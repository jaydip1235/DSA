//https://leetcode.com/problems/sort-array-by-increasing-frequency/

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int el:nums){
            map.put(el,map.getOrDefault(el,0)+1);
        }
   
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(a).equals(map.get(b))?b.compareTo(a): map.get(a)-map.get(b)); // min-heap
        int output[] = new int [nums.length];
        int index =0;
        
        for(int val:nums){
            pq.add(val);
        }
        
        while(!pq.isEmpty()){
            output[index++] = pq.poll();
        }
        
        return output;
    }
}