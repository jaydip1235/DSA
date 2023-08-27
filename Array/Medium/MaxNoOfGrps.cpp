// https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/description/
#include<bits/stdc++.h>
class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        int n = grades.size();
        long long lo = 1;  
        long long hi = n; 
        int ans = -1;
        while(lo <= hi){
            long long mid = (lo + hi) / 2; 
            long long sum = (mid * (mid + 1)) / 2;  
            if(n == sum){
                return mid;
            }        
            else if(n < sum){
                hi = mid - 1;
            } else {
                ans = mid;
                lo = mid + 1;
            }
        }
        
        return ans;
    }
};
