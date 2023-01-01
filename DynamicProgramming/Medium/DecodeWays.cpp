// https://leetcode.com/problems/decode-ways/description/
#include<bits/stdc++.h>
class Solution {
public:
    int solve(string& s,int i,vector<int>& dp){
        if(i>=s.size()) return 1;
        if(dp[i]!=-1) return dp[i];
        int pick1=0,pick2=0;
        if(s[i]-'0'> 0) {
            pick1=solve(s,i+1,dp);
            if(i+1<s.size()&&((s[i]-'0'<=2 && s[i+1]-'0'<=6)|| s[i]-'0'==1)){
                pick2=solve(s,i+2,dp);
            }
        }
        //cout<<pick1<<" "<<pick2<<endl;
        return dp[i]=pick1+pick2; 
    }
    int numDecodings(string s) {
        int n=s.size();
        vector<int> dp(n+1,-1);
        return solve(s,0,dp);
    }
};