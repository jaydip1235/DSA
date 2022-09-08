class Solution
{
public:
    int dp[102][102];

    int fun(vector<vector<int>> &arr, int i, int j, int n, int m)
    {
        if (j < 0 || j >= m)
            return 1e9;
        if (i == n - 1)
            return arr[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int v1 = arr[i][j] + fun(arr, i + 1, j, n, m);
        int v2 = arr[i][j] + fun(arr, i + 1, j + 1, n, m);
        int v3 = arr[i][j] + fun(arr, i + 1, j - 1, n, m);
        return dp[i][j] = min(v1, min(v2, v3));
    }

    int minFallingPathSum(vector<vector<int>> &arr)
    {
        memset(dp, -1, sizeof dp);
        int n = arr.size();
        int m = arr[0].size();
        int ans = 1e9;
        for (int j = 0; j < m; j++)
        {
            ans = min(ans, fun(arr, 0, j, n, m));
        }
        return ans;
    }
};