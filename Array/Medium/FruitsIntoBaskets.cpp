// https://leetcode.com/problems/fruit-into-baskets/
#include<bits/stdc++.h>
class Solution
{
public:
    int totalFruit(vector<int> &fruits)
    {
        int n = fruits.size();
        if (n <= 2)
            return n;
        int ans = 0, l = 0;
        map<int, int> mp;
        for (int r = 0; r < n; r++)
        {
            mp[fruits[r]]++;
            if (mp.size() <= 2)
            {
                ans = max(ans, r - l + 1);
            }
            else
            {
                while (l <= r && mp.size() > 2)
                {
                    mp[fruits[l]]--;
                    if (mp[fruits[l]] == 0)
                        mp.erase(fruits[l]);
                    l++;
                }
                if (mp.size() == 2)
                {
                    ans = max(ans, r - l + 1);
                }
            }
        }
        return ans;
        cout
    }
};
