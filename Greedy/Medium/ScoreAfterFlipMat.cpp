// https://leetcode.com/problems/score-after-flipping-matrix/
import java.util.*;
class Solution
{
public:
    int matrixScore(vector<vector<int>> &A)
    {
        int n = A.size();
        int m = A[0].size();
        // if first value in any row is 0, then flip the row so that most significant bit becomes set
        for (int i = 0; i < n; i++)
        {
            if (A[i][0] == 0)
            {
                for (int j = 0; j < m; j++)
                {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        // if any column has more 0 than 1, flip the column
        for (int j = 0; j < m; j++)
        {
            int cz = 0;
            int co = 0;
            for (int i = 0; i < n; i++)
            {
                if (A[i][j] == 1)
                    co++;
                else
                    cz++;
            }
            if (cz > co)
            {
                for (int i = 0; i < n; i++)
                {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            int p = 0;
            for (int j = m - 1; j >= 0; j--)
            {
                ans += A[i][j] * pow(2, p);
                p++;
            }
        }
        return ans;
    }
};