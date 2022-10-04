// https://leetcode.com/problems/number-of-provinces/

class Solution {
public:
    void dfs(int node,vector<int> adj[],vector<int>& vis){
        vis[node]=1;
        for(auto i:adj[node]){
            if(!vis[i]) dfs(i,adj,vis);
        }
    }
    int findCircleNum(vector<vector<int>>& v) {
        int n=v.size();
        vector<int> adj[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(v[i][j]==1&&i!=0){
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }
        vector<int> vis(n,0);
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis);
            }
        }
        return cnt;
        
    }
};