// https://leetcode.com/problems/jump-game/description/
#include<bits/stdc++.h>
class Solution {
public:
    bool func(vector<int>& nums, int ind, vector<int>&dp){
        if(ind>=nums.size())return 0;
        if(ind==nums.size()-1)return dp[ind]=1;
        if(dp[ind]!=-1)return dp[ind];
        int ans=0;
        for(int i=1;i<=nums[ind];i++){
            ans = ans | func(nums,ind+i,dp);
            if(ans==1)return dp[ind]=ans;
        }
        return dp[ind]=ans;
    }
    bool canJump(vector<int>& nums) {
        vector<int>dp(nums.size()+1,-1);
        return func(nums,0,dp)==1?true:false;
    }
};