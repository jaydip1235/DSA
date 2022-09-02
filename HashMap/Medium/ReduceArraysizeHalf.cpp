// https://leetcode.com/problems/reduce-array-size-to-the-half/
#include<bits/stdc++.h>
class Solution
{
public:
    int minSetSize(vector<int> &arr)
    {

        map<int, int> mp;
        for (int i = 0; i < arr.size(); i++)
        {
            mp[arr[i]]++;
        }
        multimap<int, int, greater<int>> mmp;
        for (auto it : mp)
        {
            mmp.insert({it.second, it.first});
        }
        int ans = 0;
        int sum = arr.size();
        for (auto it = mmp.begin(); it != mmp.end(); it++)
        {
            sum -= it->first;
            ans++;
            if (sum <= (arr.size() / 2))
                return ans;
        }
        return ans;
    }
};