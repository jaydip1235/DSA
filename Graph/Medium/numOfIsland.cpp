// https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

class Solution {
  public:
    void dfs(vector<vector<int>>& grid,vector<vector<int>>& vis,vector<pair<int,int>>& ans,int sr,int sc,int i,int j){
        vis[i][j]=1;
        int rows[]={0,-1,0,1};
        int cols[]={-1,0,1,0};
        int n=grid.size(),m=grid[0].size();
        ans.push_back({i-sr,j-sc});
        for(int k=0;k<4;k++){
            int r=i+rows[k],c=j+cols[k];
            if(r>=0&&r<n&&c>=0&&c<m&&vis[r][c]==0&&grid[r][c]==1) dfs(grid,vis,ans,sr,sc,r,c);
        }
    }
    int countDistinctIslands(vector<vector<int>>& grid) {
        // code here
        set<vector<pair<int,int>>> st;
        int n=grid.size(),m=grid[0].size();
        vector<vector<int>> vis(n,vector<int>(m,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]&&grid[i][j]==1){
                    vector<pair<int,int>> v;
                    dfs(grid,vis,v,i,j,i,j);
                    st.insert(v);
                }
            }
        }
        return st.size();
    }
};