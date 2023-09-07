// https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/
#include<bits/stdc++.h>
class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        int ans = 0;
        int n = nums.size();
        for(int i = 0; i < (1 << n); i++){
            int c = 0;
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0) c ^= nums[j];  
            }
            ans += c;
        }
        return ans;
    }
};
