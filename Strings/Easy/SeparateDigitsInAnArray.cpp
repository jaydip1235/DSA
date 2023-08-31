// https://leetcode.com/problems/separate-the-digits-in-an-array/description/
#include<bits/stdc++.h>
class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        vector<int>ans;
        string s="";
        for(int i=0;i<nums.size();i++){
            s+=to_string(nums[i]);
        }
        for(char ch:s){
            ans.push_back(ch-'0');
        }
        return ans;
    }
};