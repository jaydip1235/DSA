// https://leetcode.com/problems/neither-minimum-nor-maximum/description/
#include<bits/stdc++.h>
class Solution {
public:
    int findNonMinOrMax(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        if(nums.size()<=2)return -1;
        else return nums[1];
    }
};