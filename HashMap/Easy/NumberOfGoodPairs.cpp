// https://leetcode.com/problems/number-of-good-pairs/description/
#include<bitts/stdc++.h>
class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        map<int,int>mp;
        int ans=0;
        for(int i=0;i<nums.size();i++){
            if(mp.find(nums[i])==mp.end()){
                
            }else{
                ans+=mp[nums[i]];
            }
            mp[nums[i]]++;
        }
        return ans;
    }
};