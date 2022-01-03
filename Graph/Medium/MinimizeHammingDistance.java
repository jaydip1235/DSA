// https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations
import java.util.*;
public class MinimizeHammingDistance {
    int[] par;
    int[] rank;
    
    public int find(int x) {
        if(par[x] == x) {
            return x;
        }
        else {
            int ans = find(par[x]);
            par[x] = ans; //path compression 
            return ans;
        }
    }
    
    public int minimumHammingDistance(int[] source, int[] target, int[][] as) {
        
        int n = source.length;
        par = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }
        
        for(int i=0;i<as.length;i++){
            int u = as[i][0];
            int v = as[i][1];
            int lx = find(u);
            int ly = find(v);
            if(lx != ly) {
            if(rank[lx] < rank[ly]) {
                par[lx] = ly;
            }
            else if(rank[lx] > rank[ly]) {
                par[ly] = lx;
            }
            else {
                par[lx] = ly;
                rank[ly]++;
            }
            }        
            
        }
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int idx = find(i);
            int num = source[i];
            if(!map.containsKey(idx)){
                map.put(idx,new HashMap<>());
            }
             HashMap<Integer,Integer> hm = map.get(idx);
                if(!hm.containsKey(num)){
                    hm.put(num,1);
                }
                else{
                    hm.put(num,hm.get(num)+1);
                }
            
        }
        
        int ans= 0;
        for(int i=0;i<n;i++){
            int idx = find(i);
            int num = target[i];
            
            HashMap<Integer,Integer> hm = map.get(idx);
            if(!hm.containsKey(num)){
                ans++;
                continue;
            }
            if(hm.get(num)<=0)ans++;
            hm.put(num,hm.get(num)-1);
            
        }
        
       return ans; 
    }
}
