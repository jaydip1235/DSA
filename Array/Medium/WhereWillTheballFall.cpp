// https://leetcode.com/problems/where-will-the-ball-fall/
#include<bits/stdc++.h>
class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        
        vector<int>arr(m,-1);
        
        for(int i=0;i<m;i++){
            int x=0;
            int col=i;
            while(1){
            if(x>=n){
                if(col>=0 && col<m){
                    arr[i]=col;
                }
                break;
            }else{
                if(col+1<m && grid[x][col]==1 && grid[x][col+1]==1){
                    col++;x++;
                }
                else if(col-1>=0 && grid[x][col]==-1 && grid[x][col-1]==-1){
                    col--;x++;
                }else{
                    break;
                }
            }
            }
        }
        
        return arr;
    }
};