// https://leetcode.com/problems/surrounded-regions/


class Solution {
public:
    void dfs(vector<vector<char>>& cpy,vector<vector<int>>& vis,int sr,int sc){
        vis[sr][sc]=1;
        int rows[]={0,-1,0,1};
        int cols[]={-1,0,1,0};
        int n=cpy.size(),m=cpy[0].size();
        for(int i=0;i<4;i++){
            int r=rows[i]+sr,c=cols[i]+sc;
            if(r>=0&&r<n&&c>=0&&c<m&&vis[r][c]==0&&cpy[r][c]=='O') dfs(cpy,vis,r,c);
        }
    }
    void solve(vector<vector<char>>& board) {
        vector<vector<char>> cpy=board;
        int n=board.size(),m=board[0].size();
        vector<vector<int>> vis(n,vector<int>(m,0));
        for(int i=0;i<m;i++) {
            if(cpy[0][i]=='O'&&vis[0][i]==0) dfs(cpy,vis,0,i);
        }
        for(int i=0;i<m;i++) {
            if(cpy[n-1][i]=='O'&&vis[n-1][i]==0) dfs(cpy,vis,n-1,i);
        }
        for(int i=0;i<n;i++) {
            if(cpy[i][0]=='O'&&vis[i][0]==0) dfs(cpy,vis,i,0);
        }
        for(int i=0;i<n;i++) {
            if(cpy[i][m-1]=='O'&&vis[i][m-1]==0) dfs(cpy,vis,i,m-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0) cpy[i][j]='X';
            }
        }
        board=cpy;
    }
};