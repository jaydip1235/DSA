// https://leetcode.com/problems/fair-distribution-of-cookies/
#include<bits/stdc++.h>
class Solution
{
public:
    int ans = INT_MAX;

    void solve(vector<int> &cookies, vector<int> &student, int k, int index)
    {
        if (index == cookies.size())
        {
            int maxi = INT_MIN;
            for (int i = 0; i < student.size(); i++)
            {
                maxi = max(maxi, student[i]);
            }
            ans = min(ans, maxi);
            return;
        }
        for (int i = 0; i < k; i++)
        {
            student[i] += cookies[index];
            solve(cookies, student, k, index + 1);
            student[i] -= cookies[index];
        }
        return;
    }

    int distributeCookies(vector<int> &cookies, int k)
    {
        vector<int> student(k, 0);
        solve(cookies, student, k, 0);
        return ans;
    }
};