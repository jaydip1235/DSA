class Solution {
// https://leetcode.com/problems/left-and-right-sum-differences/description/
#include<bits/stdc++.h>
public:
    vector<int> leftRightDifference(vector<int>& nums) {
        int n = nums.size();
        vector<int> rightsum(n),leftsum(n),answer(n);
        int sum=0;
        for(int i=0;i<nums.size();i++){
            sum += nums[i];
            leftsum[i] = sum;
        }
        sum=0;
        for(int j=nums.size()-1;j>=0;j--){
            sum += nums[j];
            rightsum[j] = sum;
        }
        for(int k=0;k<nums.size();k++){
            answer[k] = abs(leftsum[k]-rightsum[k]); 
        }
        return answer;
    }
};