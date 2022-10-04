// https://leetcode.com/problems/rotting-oranges/

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n=grid.size(),m=grid[0].size();
        vector<vector<int>> vis(n,vector<int>(m,0));
        queue<pair<pair<int,int>,int>> Q;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    vis[i][j]=1;
                    Q.push({{i,j},0});
                }
            }
        }
        int tm=0;
        while(!Q.empty()){
            auto it=Q.front();
            Q.pop();
            int r=it.first.first,c=it.first.second,t=it.second;
            tm=max(t,tm);
            int rows[]={0,-1,0,1};
            int cols[]={-1,0,1,0};
            for(int i=0;i<4;i++){
                int row=r+rows[i],col=c+cols[i];
                if(row>=0&&row<n&&col>=0&&col<m&&vis[row][col]==0&&grid[row][col]==1){
                    vis[row][col]=1;
                    Q.push({{row,col},t+1});
                }
            }
        }
        bool f=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&grid[i][j]==1) f=false;
            }
        }
        if(f) return tm;
        return -1;
    }
};