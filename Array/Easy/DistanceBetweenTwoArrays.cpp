// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/description/
#include<bits/stdc++.h>
class Solution
{
public:
    int findTheDistanceValue(vector<int> &arr1, vector<int> &arr2, int d)
    {
        sort(arr2.begin(), arr2.end());

        int ans = 0;
        for (int i = 0; i < arr1.size(); i++)
        {
            int c1 = lower_bound(arr2.begin(), arr2.end(), arr1[i] - d) - arr2.begin();
            int c2 = upper_bound(arr2.begin(), arr2.end(), arr1[i] + d) - arr2.begin();
            c2 = arr2.size() - c2;
            if (c1 + c2 == arr2.size())
                ans++;
        }
        return ans;
    }
};