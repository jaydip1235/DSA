// https://leetcode.com/problems/longest-turbulent-subarray/
#include<bits/stdc++.h>
class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        int n=arr.size();
        if(n<2)return n;
        
        int s=0,e=0;
        int ans=1;
        while(s+1<n){
            if(arr[s]==arr[s+1]){
                s++;
                continue;
            }
            e=s+1;
            while(e+1<n && ((arr[e]>arr[e+1] && arr[e]>arr[e-1]) || (arr[e]<arr[e+1] && arr[e]<arr[e-1])) ){
                e++;
            }
            ans=max(ans,e-s+1);
            s=e;
        }
      return ans;  
        
    }
};