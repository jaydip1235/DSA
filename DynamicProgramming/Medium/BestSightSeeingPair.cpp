// https://leetcode.com/problems/best-sightseeing-pair/
#include<bits/stdc++.h>
class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& a) {
        
        int n=a.size();
        int ans=INT_MIN;
        int aiplusi=a[0]+0;
        for(int j=1;j<n;j++){
            ans=max(ans,aiplusi+a[j]-j);
            aiplusi=max(aiplusi,a[j]+j);
        }
        return ans;
        
    }
};