// https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
#include<bits/stdc++.h>
typedef long long int ll;

class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        ll ans = 0;
        int n = nums.size(), nxt = 1e9+7;
        for (int j = n-1; j >= 0; j --) {
            if (nums[j] <= nxt) {
                nxt = nums[j];
                continue;
            }
            ll parts = ceil(nums[j]/(double)nxt);
            
            ans += parts-1;            
            nxt = nums[j] / parts;;
        }
        return ans;
    }
};