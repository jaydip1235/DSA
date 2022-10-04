// https://leetcode.com/problems/flood-fill/
 
 class Solution {
public:
    void dfs(vector<vector<int>>& cpy,vector<vector<int>>& vis,int i,int j,int curr,int col){
        vis[i][j]=1;
        cpy[i][j]=col;
        int rows[]={0,-1,0,1};
        int cols[]={-1,0,1,0};
        int n=cpy.size(),m=cpy[0].size();
        for(int k=0;k<4;k++){
            int r=rows[k]+i,c=cols[k]+j;
            if(r>=0&&r<n&&c>=0&&c<m&&vis[r][c]==0&&cpy[r][c]==curr) dfs(cpy,vis,r,c,curr,col);
        }
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int n=image.size(),m=image[0].size();
        vector<vector<int>> cpy=image;
        vector<vector<int>> vis(n,vector<int>(m,0));
        int curr=image[sr][sc];
        dfs(cpy,vis,sr,sc,curr,color);
        return cpy;
    }
};