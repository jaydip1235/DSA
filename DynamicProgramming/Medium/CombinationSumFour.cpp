// https://leetcode.com/problems/combination-sum-iv/description
#include<bits/stdc++.h>
class Solution {
public:
 int combinationSum4(vector<int>& nums, int target) {
	vector<int> dp(target + 1, -1);
	return helper(nums, target, dp);
}
int helper(vector<int>& nums, int target, vector<int>& dp){
	if(target == 0) return 1; 
	if(dp[target] != -1) return dp[target];  
	dp[target] = 0;
	for(auto& num : nums) 
		if(num <= target) dp[target] += helper(nums, target - num, dp);
	return dp[target];
}
};