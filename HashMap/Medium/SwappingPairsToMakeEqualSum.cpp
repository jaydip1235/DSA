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

class Solution
{
public:
    int maxLen(vector<int> &arr, int n)
    {
        map<int, int> mp;
        vector<int> pre(n, 0);
        pre[0] = arr[0];
        mp[arr[0]] = 0;
        int maxi = 0;

        for (int i = 1; i < n; i++)
        {
            pre[i] = pre[i - 1] + arr[i];
            if (pre[i] == 0)
            {
                maxi = max(maxi, i + 1);
            }
            else
            {
                if (mp.find(pre[i]) == mp.end())
                {
                    mp[pre[i]] = i;
                }
                else
                {
                    maxi = max(maxi, i - mp[pre[i]]);
                }
            }
        }
        return maxi;
    }
};