// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
import java.util.*;
public class ToMakeStronglyConnected {
    int[] parent;
    int[] rank;
    public int makeConnected(int n, int[][] graph) {
      if((n-1)>graph.length)return -1;
      parent = new int[n];
      rank = new int[n];  
      for(int i=0;i<n;i++){
          parent[i]=i;
          rank[i]=0;
      }
      for(int i=0;i<graph.length;i++){
          int u = graph[i][0];
          int v = graph[i][1];
          int par1 = find(u);
          int par2 = find(v);
                if(par1!=par2){
                  if(rank[par1]<rank[par2]){
                      parent[par1]=par2;
                  }
                  else if(rank[par1]>rank[par2]){
                       parent[par2]=par1;
                  }else{
                      parent[par1]=par2;
                      rank[par2]++;
                  }
              }
      }
      int ans=0;
    
      for(int i=0;i<n;i++){
          if(parent[i]==i)ans++;
      }
        return ans-1;
    }
     public int find(int x){
        if(parent[x]==x)return x;
        else{
            int ans = find(parent[x]);
            parent[x]=ans;
            return ans;
        }
    }
}
