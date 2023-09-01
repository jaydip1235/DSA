// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/
#include<bits/stdc++.h>
class Solution {
public:
    int countPairs(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        int ans=0;
        int i=0,j=nums.size()-1;
        while(i<j){
            if(nums[i]+nums[j]>=target)j--;
            else{
                ans+=(j-i);
                i++;
            }
        }
        return ans;
    }
};