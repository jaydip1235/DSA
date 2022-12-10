// https://leetcode.com/problems/minimum-penalty-for-a-shop/description/
#include<bits/stdc++.h>
class Solution
{
public:
    int bestClosingTime(string s)
    {
        int ans = 1e9;
        int totY = 0;
        for (int i = 0; i < s.size(); i++)
        {
            totY += s[i] == 'Y' ? 1 : 0;
        }
        int currY = 0;
        int currN = 0;
        int hr = 0;
        for (int i = 0; i < s.size(); i++)
        {
            int curr = totY - currY + currN;
            if (curr < ans)
            {
                ans = curr;
                hr = i;
            }
            currY += s[i] == 'Y' ? 1 : 0;
            currN += s[i] == 'N' ? 1 : 0;
        }
        int curr = totY - currY + currN;
        if (curr < ans)
        {
            ans = curr;
            hr = s.size();
        }
        return hr;
    }
};