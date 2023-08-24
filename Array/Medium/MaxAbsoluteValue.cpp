// https://leetcode.com/problems/maximum-of-absolute-value-expression/description/
#include<bits/stdc++.h>
class Solution {
public:
    int maxAbsValExpr(vector<int>& arr1, vector<int>& arr2) {
        int ans=INT_MIN;
        int maxi=INT_MIN;
        int mini=INT_MAX;
        for(int i=0;i<arr1.size();i++){
            maxi=max(maxi,i+arr1[i]+arr2[i]);
            mini=min(mini,i+arr1[i]+arr2[i]);
        }
        ans=max(ans,maxi-mini);
        maxi=INT_MIN;
        mini=INT_MAX;
        for(int i=0;i<arr1.size();i++){
            maxi=max(maxi,i-arr1[i]-arr2[i]);
            mini=min(mini,i-arr1[i]-arr2[i]);
        }
        ans=max(ans,maxi-mini);
        maxi=INT_MIN;
        mini=INT_MAX;
        for(int i=0;i<arr1.size();i++){
            maxi=max(maxi,i-arr1[i]+arr2[i]);
            mini=min(mini,i-arr1[i]+arr2[i]);
        }
        ans=max(ans,maxi-mini);
        maxi=INT_MIN;
        mini=INT_MAX;
        for(int i=0;i<arr1.size();i++){
            maxi=max(maxi,i+arr1[i]-arr2[i]);
            mini=min(mini,i+arr1[i]-arr2[i]);
        }
    
        return max(ans,maxi-mini);
    }
};