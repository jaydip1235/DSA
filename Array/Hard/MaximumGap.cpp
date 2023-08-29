// https://leetcode.com/problems/maximum-gap/description/
#include<bits/stdc++.h>
class Solution {
public:
    int maximumGap(vector<int>& nums) {
        if(nums.size()<2)return 0;
        int mini=nums[0],maxi=0;
        for(int num:nums){
            mini=min(mini,num);
            maxi=max(maxi,num);
        }
        int interval=(int)ceil((maxi-mini+0.0)/(nums.size()-1));
        vector<int>minbuck(nums.size()-1,INT_MAX);
        vector<int>maxbuck(nums.size()-1,0);

        for(int i=0;i<nums.size();i++){
           if(nums[i]==mini || nums[i]==maxi)continue;
           int index = (nums[i]-mini)/interval;
           minbuck[index]=min(minbuck[index],nums[i]);
           maxbuck[index]=max(maxbuck[index],nums[i]);
        }

        int prev=mini,ans=0;
        for(int i=0;i<minbuck.size();i++){
            if(maxbuck[i]==0)
            {
                continue;
            }
            ans=max(ans,minbuck[i]-prev);
            prev=maxbuck[i];
        }
        ans=max(ans,maxi-prev);
        return ans;

    }
};