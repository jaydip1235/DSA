// https://leetcode.com/problems/concatenation-of-array/description/
#include<bits/stdc++.h>
class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        int n=nums.size();
        vector<int>ans(2*n);
        for(int i=0;i<2*n;i++){
            ans[i]=nums[i%n];
        }
        return ans;
    }
};