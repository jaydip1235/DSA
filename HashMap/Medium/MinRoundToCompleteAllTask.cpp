// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
#include<bits/stdc++.h>
class Solution
{
public:
    int minimumRounds(vector<int> &arr)
    {
        map<int, int> mp;
        int ans = 0;
        for (int i = 0; i < arr.size(); i++)
            mp[arr[i]]++;
        for (auto it = mp.begin(); it != mp.end(); it++)
        {
            if (it->second == 1)
            {
                ans = -1;
                break;
            }
            if ((it->second) % 3 == 0)
                ans += (it->second) / 3;
            else
                ans += ((it->second) / 3) + 1;
        }
        return ans;
    }
};