// https://leetcode.com/problems/range-sum-query-2d-immutable/description/
#include<bits/stdc++.h>
class NumMatrix {
public:
    vector<vector<int>>dp;
    NumMatrix(vector<vector<int>>& matrix) {
        if(matrix.size()==0 || matrix[0].size()==0)return;
         int m = matrix.size();
         int n = matrix[0].size();

        dp.resize(m+1);
         for (int i = 0; i <= m; i++) {
        dp[i].resize(n+1, 0);
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] -dp[i - 1][j - 1] + matrix[i - 1][j - 1] ;
            }
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
          return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */