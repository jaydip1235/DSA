// https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal4142/1
class Solution
{

public:
    int findSwapValues(int A[], int n, int B[], int m)
    {
        int sa = 0;
        int sb = 0;
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++)
            sa += A[i];
        for (int i = 0; i < m; i++)
        {
            sb += B[i];
            mp[B[i]] = 1;
        }

        int delta = (sb - sa) / 2;

        for (int i = 0; i < n; i++)
        {
            if ((sb - sa) % 2 == 0 && mp.find(A[i] + delta) != mp.end())
                return 1;
        }

        return -1;
    }
};