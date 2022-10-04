// https://leetcode.com/problems/number-of-enclaves/

class Solution {
public:
    void dfs(vector<vector<int>>& grid,vector<vector<int>>& vis,int sr,int sc){
        vis[sr][sc]=1;
        int rows[]={0,-1,0,1};
        int cols[]={-1,0,1,0};
        int n=grid.size(),m=grid[0].size();
        for(int i=0;i<4;i++){
            int r=sr+rows[i],c=sc+cols[i];
            if(r>=0&&r<n&&c>=0&&c<m&&vis[r][c]==0&&grid[sr][sc]==1) dfs(grid,vis,r,c);
        }
    }
    int numEnclaves(vector<vector<int>>& grid) {
        int n=grid.size(),m=grid[0].size();
        vector<vector<int>> vis(n,vector<int>(m,0));
        for(int i=0;i<n;i++){
            if(grid[i][0]==1&&!vis[i][0]) dfs(grid,vis,i,0);
        }
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==1&&!vis[i][m-1]) dfs(grid,vis,i,m-1);
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==1&&!vis[0][i]) dfs(grid,vis,0,i);
        }
        for(int i=0;i<m;i++){
            if(grid[n-1][i]==1&&!vis[n-1][i]) dfs(grid,vis,n-1,i);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&!vis[i][j]) cnt++;
            }
        }
        return cnt;
    }
};