// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
#include<bits/stdc++.h>
class Solution {
public:
    int rangeSum(vector<int>& nums, int n, int left, int right) {
        vector<int>sum;
        for(int i=0;i<n;i++){
            int s=nums[i];
            sum.push_back(s);
            for(int j=i+1;j<n;j++){
                s+=nums[j];
                sum.push_back(s);
            }
        }
        sort(sum.begin(),sum.end());
        long ans=0;
        for(int i=left-1;i<=right-1;i++){
            ans=(ans+sum[i])%1000000007;
        }
        return ans;
    }
};