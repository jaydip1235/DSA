// https://leetcode.com/problems/max-consecutive-ones/
#include<bits/stdc++.h>
class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        
        int maxi = INT_MIN;
        int count=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==1)count++;
            else count=0;
            maxi = max(maxi,count);
        }
        return maxi;
    }
};