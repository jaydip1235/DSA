// https://leetcode.com/problems/first-bad-version/
#include<bits/stdc++.h>
class Solution {
public:
    int firstBadVersion(int n) {
        
       int lo=1,hi=n;
       int ans=-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(isBadVersion(mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
};