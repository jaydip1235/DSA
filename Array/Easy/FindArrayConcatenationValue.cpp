// https://leetcode.com/problems/find-the-array-concatenation-value/
#include<bits/stdc++.h>
class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
    long long res = 0, sz = nums.size();
    for (int i = 0, j = sz - 1; i <= j; ++i, --j)
        if (i < j)
            res += nums[i] * pow(10, (int)log10(nums[j]) + 1) + nums[j];
        else
            res += nums[i];
    return res;
}
};