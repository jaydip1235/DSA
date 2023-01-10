// https://leetcode.com/problems/number-of-arithmetic-triplets/
#include<bits/stdc++.h>
class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            if(i>0){
                while(nums[i]==nums[i-1] && i<n-1)i++;
            }
            int lb = lower_bound(nums.begin()+i+1,nums.end(),nums[i]+diff)-nums.begin();
            if(lb!=n && nums[lb]-nums[i]==diff){
                int slb = lower_bound(nums.begin()+lb+1,nums.end(),nums[lb]+diff)-nums.begin();
                if(slb!=n && nums[slb]-nums[lb]==diff)ans++;
            }
        }
        return ans;
    }
};