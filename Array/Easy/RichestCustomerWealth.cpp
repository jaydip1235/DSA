// https://leetcode.com/problems/richest-customer-wealth/description/
#include<bits/stdc++.h>
class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        int maxi=0;
        for(int i=0;i<accounts.size();i++){
            int w=0;
            for(int j=0;j<accounts[i].size();j++){
                w+=accounts[i][j];
            }
            maxi=max(maxi,w);
        }
        return maxi;
    }
};