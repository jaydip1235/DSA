// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
#include<bits/stdc++.h>
class Solution {
public:
    int minCost(string s, vector<int>& arr) {
        
        int i=0,j=0,ans=0;
        int maxi=INT_MIN;

        int tsum=0;
        for(int i=0;i<arr.size();i++)tsum+=arr[i];
        
        while(j<s.size()){
            if(s[i]==s[j]){
                maxi=max(maxi,arr[j]);
                j++;
            }
            else{
                i=j;
                ans+=maxi;
                maxi=INT_MIN;
                
            }
        }
        ans+=maxi;
        return tsum-ans;
    }
};