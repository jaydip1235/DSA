// https://leetcode.com/problems/minimum-path-cost-in-a-grid/
#include<bits/stdc++.h>
class Solution
{
public:
    int n, m;
    int dp[51][51];
    int solve(vector<vector<int>> &grid, vector<vector<int>> &moveCost, int row, int col)
    {
        if (row == n - 1)
            return grid[row][col];
        if (dp[row][col] != -1)
            return dp[row][col];
        int idx = grid[row][col];
        int ans = INT_MAX;
        for (int i = 0; i < m; i++)
        {
            int val = idx + moveCost[idx][i] + solve(grid, moveCost, row + 1, i);
            ans = min(ans, val);
        }
        return dp[row][col] = ans;
    }
    int minPathCost(vector<vector<int>> &grid, vector<vector<int>> &moveCost)
    {
        n = grid.size();
        m = grid[0].size();
        int ans = INT_MAX;
        memset(dp, -1, sizeof(dp));
        for (int i = 0; i < m; i++)
        {
            int val = solve(grid, moveCost, 0, i);
            ans = min(ans, val);
        }
        return ans;
    }
};