// https://leetcode.com/problems/container-with-most-water/
#include<bits/stdc++.h>
class Solution
{
public:
    int maxArea(vector<int> &arr)
    {
        long ans = 0;
        int i = 0, j = arr.size() - 1;
        while (i < j)
        {
            long w = j - i;
            long h = min(arr[i], arr[j]);
            ans = max(ans, h * w);
            if (arr[i] < arr[j])
                i++;
            else
                j--;
        }
        return ans;
    }
};