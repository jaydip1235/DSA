// https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
#include<bits/stdc++.h>
class Solution
{
public:
    int matchPlayersAndTrainers(vector<int> &p, vector<int> &t)
    {

        sort(p.begin(), p.end());
        sort(t.begin(), t.end());

        int ans = 0, found = 0;
        for (int i = 0; i < p.size(); i++)
        {
            auto x = lower_bound(t.begin() + found, t.end(), p[i]) - t.begin();
            if (x == t.size())
                break;
            ans++;
            found = x + 1;
        }

        return ans;
    }
};