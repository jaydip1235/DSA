// https://leetcode.com/problems/number-of-provinces/
import java.util.*;

public class NumberOfProvinces {
    int[] parent;
    int[] rank;
    public int findCircleNum(int[][] isConnected) {
      int n = isConnected.length;  
      parent = new int[n];
      rank = new int[n];  
      for(int i=0;i<n;i++){
          parent[i]=i;
          rank[i]=0;
      }
      for(int i=0;i<isConnected.length;i++){
          for(int j=0;j<isConnected[i].length;j++){
              if(isConnected[i][j]==1){
              int u = i;
              int v = j;
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
          }
      }
        
        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i)count++;
        }
        return count;
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
