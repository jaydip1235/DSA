// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
bool dfs(int node,int par,vector<int>& vis,vector<int> adj[]){
        vis[node]=1;
        for(auto i:adj[node]){
            if(!vis[i]) {
                if(dfs(i,node,vis,adj)) return true;
            }
            else if(i!=par) return true;
        }
        return false;
    }
    bool isCycle(int V, vector<int> adj[]) {
        // Code here
        vector<int> vis(V,0);
        for(int i=0;i<V;i++){
            if(!vis[i]) {
                if(dfs(i,-1,vis,adj)) return true;
            }
        }
        return false;
    }
    