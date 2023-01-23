// https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
#include<bits/stdc++.h>
class Solution
{
public:
    vector<int> countDistinct(int arr[], int n, int k)
    {
        vector<int> ans;
        map<int, int> mp;
        for (int i = 0; i < k; i++)
        {
            mp[arr[i]]++;
        }
        ans.push_back(mp.size());
        for (int i = k; i < n; i++)
        {
            mp[arr[i]]++;
            mp[arr[i - k]]--;
            if (mp[arr[i - k]] == 0)
                mp.erase(arr[i - k]);
            ans.push_back(mp.size());
        }
        return ans;
    }
};