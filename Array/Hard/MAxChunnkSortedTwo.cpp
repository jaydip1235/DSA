// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
#include<bits/stdc++.h>
class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        int n=arr.size();
        vector<int>rmin(n+1);
        rmin[n]=INT_MAX;
        for(int i=n-1;i>=0;i--){
            rmin[i]=min(arr[i],rmin[i+1]);
        }
        int ans=0,lmax=0;
        for(int i=0;i<n;i++){
            lmax=max(lmax,arr[i]);
            if(lmax<=rmin[i+1])ans++;
        }
        return ans;
    }
};