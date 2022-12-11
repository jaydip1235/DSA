// https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/
#include<bits/stdc++.h>
class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        vector<vector<int>> diff(n,vector<int>(m,0));

        vector<int>row(n,0);
        vector<int>col(m,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    row[i]+=1;
                    col[j]+=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               diff[i][j]=row[i]+col[j]-(m-row[i])-(n-col[j]);
            }
        }
        return diff;
    }
};