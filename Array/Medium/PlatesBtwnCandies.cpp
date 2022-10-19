// https://leetcode.com/problems/plates-between-candles/
#include<bits/stdc++.h>
class Solution
{
public:
    vector<int> platesBetweenCandles(string s, vector<vector<int>> &queries)
    {
        int n = s.size();
        vector<int> total(n, 0);
        if (s[0] == '*')
            total[0] = 1;
        for (int i = 1; i < s.size(); i++)
        {
            if (s[i] == '*')
                total[i] = total[i - 1] + 1;
            else
                total[i] = total[i - 1];
        }
        vector<int> left(n, -1);
        if (s[0] == '|')
            left[0] = 0;
        for (int i = 1; i < s.size(); i++)
        {
            if (s[i] == '|')
                left[i] = i;
            else
                left[i] = left[i - 1];
        }

        vector<int> right(n, -1);
        if (s[s.size() - 1] == '|')
            right[n - 1] = n - 1;
        for (int i = s.size() - 2; i >= 0; i--)
        {
            if (s[i] == '|')
                right[i] = i;
            else
                right[i] = right[i + 1];
        }
        vector<int> ans;
        for (int i = 0; i < queries.size(); i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            if (right[l] == -1 || left[r] == -1 || l >= r)
                ans.push_back(0);
            else
                ans.push_back(total[left[r]] - total[right[l]] < 0 ? 0 : total[left[r]] - total[right[l]]);
        }

        return ans;
    }
};