// https://leetcode.com/problems/path-with-minimum-effort/
#include<bits/stdc++.h>
class Solution {
public:
    
    bool dfs(int i, int j, int mid, int n, int m,vector<vector<int>>& h, int vis[100][100]){
        
        if(i==n-1 && j==m-1)return true;
        vis[i][j]=1;
        bool res=false;
        if(i>0 && vis[i-1][j]==0 && abs(h[i][j]-h[i-1][j])<=mid){
            res  = res || dfs(i-1,j,mid,n,m,h,vis);
        }
        if(j>0 && vis[i][j-1]==0 && abs(h[i][j]-h[i][j-1])<=mid){
            res  = res || dfs(i,j-1,mid,n,m,h,vis);
        }
        if(i<n-1 && vis[i+1][j]==0 && abs(h[i][j]-h[i+1][j])<=mid){
            res  = res || dfs(i+1,j,mid,n,m,h,vis);
        }
        if(j<m-1 && vis[i][j+1]==0 && abs(h[i][j]-h[i][j+1])<=mid){
            res  = res || dfs(i,j+1,mid,n,m,h,vis);
        }
        return res;
    }
    
    int minimumEffortPath(vector<vector<int>>& h) {
        
        int s=0,e=INT_MAX,ans=INT_MAX,n=h.size(),m=h[0].size();
        while(s<=e){
            int mid=(s+e)/2;
            int vis[100][100];
            memset(vis,0,sizeof vis);
            if(dfs(0,0,mid,n,m,h,vis)){
                ans = min(ans,mid);
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
};