// https://leetcode.com/problems/k-closest-points-to-origin/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->compare(a,b));
        int n = points.length;
        
        for(int i=0; i<n; i++){
          pq.add(points[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int output[][]= new int [k][2];
        int index =0;
        while(!pq.isEmpty()){
            output[index++]= pq.poll();
        }
        return output;
    }
    private int compare(int [] one , int [] two ){
        double distance_1 = one[0]*one[0]+one[1]*one[1];
        double distance_2 = two[0]*two[0]+two[1]*two[1];
        return distance_1<distance_2?1:-1;
    }
}