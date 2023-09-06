// https://leetcode.com/problems/keep-multiplying-found-values-by-two/description/
#include<bits/stdc++.h>
class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        map<int,bool>mp;
        for(int i=0;i<nums.size();i++){
            mp[nums[i]]=true;
        }
        int ans=original;
        while(1){
            if(mp.find(ans)!=mp.end()){
                ans*=2;
            }else{
                break;
            }
        }
        return ans;
    }
};