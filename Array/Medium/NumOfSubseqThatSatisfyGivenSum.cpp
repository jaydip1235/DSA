// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
#include<bits/stdc++.h>
class Solution {
public: int mod = 1e9+7;
    int numSubseq(vector<int>& a, int k) {
        vector<int> twopower{1}; //precompute pow of 2 
        
        for(int i = 0;i<a.size();i++){
            twopower.push_back((twopower.back()*2)%mod);
        }
        
        sort(begin(a),end(a)); 
        int ans = 0;
        
        int i = 0,j = a.size()-1; 
        
        while(i<=j){
            
            if(a[i]+a[j]>k){
                j--;
            }
            else{
                int rem = j-i,r = 0;
                ans = (ans + twopower[rem]) % mod;
                i++;
            }
        }
        return ans;
    } 
};