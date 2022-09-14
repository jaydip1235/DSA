// https://leetcode.com/problems/max-chunks-to-make-sorted/
#include<bits/stdc++.h>
class Solution
{
public:
    int maxChunksToSorted(vector<int> &arr)
    {
        int ans = 0;
        int maxi = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            maxi = max(maxi, arr[i]);
            if (i == maxi)
                ans++;
        }
        return ans;
    }
};