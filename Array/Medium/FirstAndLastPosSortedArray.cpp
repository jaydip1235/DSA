// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
#include<bits/stdc++.h>
class Solution
{
public:
    vector<int> searchRange(vector<int> &arr, int target)
    {
        vector<int> ans;
        ans.push_back(-1);
        ans.push_back(-1);
        int lo = 0, hi = arr.size() - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target)
            {
                ans[0] = mid;
                hi = mid - 1;
            }
            else if (arr[mid] < target)
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }
        lo = 0, hi = arr.size() - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target)
            {
                ans[1] = mid;
                lo = mid + 1;
            }
            else if (arr[mid] < target)
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }
        return ans;
    }
};