// https://leetcode.com/problems/trapping-rain-water/submissions/
#include<bits/stdc++.h>
class Solution {
public:
    int trap(vector<int>& height) {
        int ans=0;
        int n=height.size();
        vector<int>lmax(n);
        vector<int>rmax(n);
        int maxi=0;
        for(int i=0;i<n;i++){
           lmax[i]=maxi;
           maxi=max(maxi,height[i]);
        }
        maxi=0;
         for(int i=n-1;i>=0;i--){
           rmax[i]=maxi;
           maxi=max(maxi,height[i]);
        }
        for(int i=0;i<n;i++){
            if((min(lmax[i],rmax[i]))-height[i]>0)
            ans+=(min(lmax[i],rmax[i]))-height[i];
        }
        return ans;
    }
};